import Image from "next/image";
import { services } from "@/lib/site-content";
import { ServiceLink } from "./service-link";

export function Services() {
  return (
    <section className="services section container" id="servicos" aria-labelledby="services-title">
      <div className="section-heading">
        <div><p className="section-label"><span>01</span> Nossos serviços</p><h2 id="services-title">Uma solução para<br />cada etapa.</h2></div>
        <p className="section-intro">Uma nova cidade. Mais espaço. Um recomeço.<br />Escolha o apoio que você precisa para<br className="desktop-break" /> chegar ao próximo endereço.</p>
      </div>
      <div className="service-grid">
        {services.map((service) => <article className="service-card" key={service.id}>
          <div className="service-photo"><Image src={service.image} alt={service.imageAlt} fill sizes="(max-width: 599px) calc(100vw - 40px), (max-width: 1023px) 45vw, 300px" /><span className="service-number">{service.number}</span></div>
          <h3>{service.title}</h3><p>{service.description}</p>
          <ServiceLink service={service.id} title={service.title} />
        </article>)}
      </div>
    </section>
  );
}
