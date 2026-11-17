"use client";

import { useEffect, useRef, useState, type FormEvent } from "react";
import { services, type ServiceId } from "@/lib/site-content";
import { formatCep, todayInSaoPaulo, validateQuote, type QuoteErrors, type QuoteValues } from "@/lib/quote-validation";
import { ArrowIcon, ArrowUpRightIcon, CheckIcon } from "./icons";

const emptyQuote: QuoteValues = {
  name: "", channel: "email", contact: "", origin: "", destination: "",
  date: "", dateUnknown: false, rooms: "", services: [],
};

function FieldError({ field, errors }: { field: keyof QuoteValues; errors: QuoteErrors }) {
  return errors[field] ? <p id={`error-${field}`} className="field-error">{errors[field]}</p> : null;
}

export function QuoteForm({ initialToday }: { initialToday: string }) {
  const [values, setValues] = useState<QuoteValues>(emptyQuote);
  const [errors, setErrors] = useState<QuoteErrors>({});
  const [complete, setComplete] = useState(false);
  const [announcement, setAnnouncement] = useState("");
  const [today, setToday] = useState(initialToday);
  const successRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    setToday(todayInSaoPaulo());
    const onSelect = (event: Event) => {
      const id = (event as CustomEvent<ServiceId>).detail;
      const service = services.find((item) => item.id === id);
      if (!service) return;
      setComplete(false);
      setValues((current) => ({ ...current, services: current.services.includes(id) ? current.services : [...current.services, id] }));
      setErrors((current) => ({ ...current, services: undefined, destination: undefined }));
      setAnnouncement(`${service.title} incluído no orçamento.`);
    };
    window.addEventListener("quote:select-service", onSelect);
    return () => window.removeEventListener("quote:select-service", onSelect);
  }, []);

  useEffect(() => {
    if (complete) successRef.current?.focus();
  }, [complete]);

  function update<K extends keyof QuoteValues>(field: K, value: QuoteValues[K]) {
    setValues((current) => ({ ...current, [field]: value }));
    setErrors((current) => ({ ...current, [field]: undefined, ...(field === "dateUnknown" ? { date: undefined } : {}) }));
  }

  function toggleService(id: ServiceId) {
    update("services", values.services.includes(id) ? values.services.filter((item) => item !== id) : [...values.services, id]);
    setErrors((current) => ({ ...current, destination: undefined }));
  }

  function submit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    const nextErrors = validateQuote(values);
    setErrors(nextErrors);
    if (Object.keys(nextErrors).length) {
      setAnnouncement("Confira os campos indicados para concluir a simulação.");
      const firstField = (["services", "origin", "destination", "date", "rooms", "name", "contact"] as const).find((field) => nextErrors[field]);
      requestAnimationFrame(() => document.getElementById(`quote-${firstField}`)?.focus());
      return;
    }
    setAnnouncement("");
    setComplete(true);
  }

  const storageOnly = values.services.length === 1 && values.services[0] === "armazenagem";
  const describedBy = (field: keyof QuoteValues) => errors[field] ? `error-${field}` : undefined;

  return (
    <section className="quote-section section container" id="orcamento" aria-labelledby="quote-title">
      <div className="quote-heading">
        <p className="section-label"><span>03</span> Orçamento grátis</p>
        <h2 id="quote-title">Vamos planejar<br />sua mudança<span className="orange-text">?</span></h2>
        <p>Conte um pouco sobre o seu próximo passo.<br />Tudo começa com um planejamento.</p>
        <div className="quote-route-art" aria-hidden="true"><span /><div /><ArrowUpRightIcon width="46" height="46" /></div>
        <div className="demo-note"><span className="demo-note-line" /><div><strong>Projeto acadêmico</strong><p>Este formulário é uma simulação. Os dados ficam apenas nesta página e nenhum pedido é enviado.</p></div></div>
      </div>

      <div className="quote-panel">
        <p className="sr-only" role="status" aria-live="polite">{announcement}</p>
        {complete ? (
          <div className="quote-success" ref={successRef} tabIndex={-1}>
            <span className="success-icon"><CheckIcon width="38" height="38" /></span>
            <p className="section-label">Simulação concluída</p>
            <h3>Seu planejamento<br />já tem um começo.</h3>
            <p>Nenhum pedido foi enviado. Esta é uma demonstração acadêmica e seus dados não foram armazenados.</p>
            <dl className="quote-summary"><div><dt>Serviços escolhidos</dt><dd>{services.filter((service) => values.services.includes(service.id)).map((service) => service.shortTitle).join(", ")}</dd></div><div><dt>Origem</dt><dd>{formatCep(values.origin)}</dd></div><div><dt>Destino</dt><dd>{values.destination ? formatCep(values.destination) : "Não informado — armazenagem"}</dd></div><div><dt>Data estimada</dt><dd>{values.dateUnknown ? "Ainda não definida" : values.date.split("-").reverse().join("/")}</dd></div></dl>
            <button className="button button-orange" type="button" onClick={() => {
              setValues(emptyQuote); setErrors({}); setComplete(false);
              requestAnimationFrame(() => document.getElementById("quote-name")?.focus());
            }}>Simular outro pedido<ArrowIcon /></button>
          </div>
        ) : (
          <form onSubmit={submit} noValidate aria-label="Simulação de pedido de orçamento" aria-describedby="quote-privacy">
            <div className="form-heading"><h3>Sobre a sua mudança</h3><span>Simulação</span></div>

            <fieldset className="service-options" aria-describedby={describedBy("services")}>
              <legend>Quais serviços você precisa?</legend>
              <div>{services.map((service, index) => <label className={`service-option ${values.services.includes(service.id) ? "selected" : ""}`} key={service.id}>
                <input id={index === 0 ? "quote-services" : `quote-service-${service.id}`} name="services" type="checkbox" value={service.id} checked={values.services.includes(service.id)} onChange={() => toggleService(service.id)} aria-invalid={Boolean(errors.services)} />
                <span className="option-check" aria-hidden="true"><CheckIcon width="13" height="13" /></span><span>{service.shortTitle}</span>
              </label>)}</div>
              <FieldError field="services" errors={errors} />
            </fieldset>

            <div className="form-grid route-fields">
              <div className="form-field route-origin"><label htmlFor="quote-origin"><span className="route-dot" />CEP de origem</label><input id="quote-origin" name="origin" type="text" inputMode="numeric" maxLength={9} placeholder="00000-000" autoComplete="off" value={values.origin} onChange={(event) => update("origin", formatCep(event.target.value))} required aria-invalid={Boolean(errors.origin)} aria-describedby={describedBy("origin")} /><FieldError field="origin" errors={errors} /></div>
              <div className="form-field route-destination"><label htmlFor="quote-destination"><span className="route-dot destination-dot" />CEP de destino{storageOnly && <span className="optional-label">(opcional)</span>}</label><input id="quote-destination" name="destination" type="text" inputMode="numeric" maxLength={9} placeholder="00000-000" autoComplete="off" value={values.destination} onChange={(event) => update("destination", formatCep(event.target.value))} required={!storageOnly} aria-invalid={Boolean(errors.destination)} aria-describedby={describedBy("destination")} /><FieldError field="destination" errors={errors} /></div>
            </div>

            <div className="form-grid">
              <div className="form-field"><label htmlFor="quote-date">Data estimada</label><input id="quote-date" name="date" type="date" min={today} value={values.date} onChange={(event) => update("date", event.target.value)} disabled={values.dateUnknown} required={!values.dateUnknown} aria-invalid={Boolean(errors.date)} aria-describedby={describedBy("date")} /><label className="checkbox-label" htmlFor="date-unknown"><input id="date-unknown" type="checkbox" checked={values.dateUnknown} onChange={(event) => update("dateUnknown", event.target.checked)} />Ainda não sei</label><FieldError field="date" errors={errors} /></div>
              <div className="form-field"><label htmlFor="quote-rooms">Número de quartos</label><select id="quote-rooms" name="rooms" value={values.rooms} onChange={(event) => update("rooms", event.target.value)} required aria-invalid={Boolean(errors.rooms)} aria-describedby={describedBy("rooms")}><option value="" disabled>Selecione</option><option value="0">Studio / sem quartos</option><option value="1">1 quarto</option><option value="2">2 quartos</option><option value="3">3 quartos</option><option value="4">4 quartos ou mais</option><option value="na">Não se aplica</option></select><FieldError field="rooms" errors={errors} /></div>
            </div>

            <div className="form-divider" />
            <h3 className="contact-heading">Como podemos falar com você?</h3>
            <div className="form-field name-field"><label htmlFor="quote-name">Seu nome</label><input id="quote-name" name="name" type="text" autoComplete="name" maxLength={100} placeholder="Nome completo" value={values.name} onChange={(event) => update("name", event.target.value)} required aria-invalid={Boolean(errors.name)} aria-describedby={describedBy("name")} /><FieldError field="name" errors={errors} /></div>

            <fieldset className="contact-channel"><legend>Prefiro contato por</legend>{([{ value: "email", label: "E-mail" }, { value: "phone", label: "Telefone" }] as const).map((channel) => <label key={channel.value}><input type="radio" name="channel" value={channel.value} checked={values.channel === channel.value} onChange={() => {
              setValues((current) => ({ ...current, channel: channel.value, contact: "" }));
              setErrors((current) => ({ ...current, contact: undefined }));
            }} />{channel.label}</label>)}</fieldset>

            <div className="form-field"><label htmlFor="quote-contact">{values.channel === "email" ? "Seu e-mail" : "Telefone com DDD"}</label><input id="quote-contact" name="contact" type={values.channel === "email" ? "email" : "tel"} autoComplete={values.channel === "email" ? "email" : "tel"} maxLength={values.channel === "email" ? 254 : 24} placeholder={values.channel === "email" ? "voce@exemplo.com" : "(11) 99999-9999"} value={values.contact} onChange={(event) => update("contact", event.target.value)} required aria-invalid={Boolean(errors.contact)} aria-describedby={describedBy("contact")} /><FieldError field="contact" errors={errors} /></div>

            <button type="submit" className="button button-orange submit-button">Simular pedido de orçamento<ArrowUpRightIcon /></button>
            <p className="form-privacy" id="quote-privacy">Simulação gratuita. Sem envio de dados ou contratação.</p>
          </form>
        )}
      </div>
    </section>
  );
}
