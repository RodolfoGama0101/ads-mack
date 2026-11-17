import { services, type ServiceId } from "./site-content.ts";

export type QuoteValues = {
  name: string;
  channel: "email" | "phone";
  contact: string;
  origin: string;
  destination: string;
  date: string;
  dateUnknown: boolean;
  rooms: string;
  services: ServiceId[];
};

export type QuoteErrors = Partial<Record<keyof QuoteValues, string>>;

export function todayInSaoPaulo(now = new Date()): string {
  const parts = new Intl.DateTimeFormat("en", {
    timeZone: "America/Sao_Paulo",
    year: "numeric",
    month: "2-digit",
    day: "2-digit",
  }).formatToParts(now);
  const part = (type: string) => parts.find((item) => item.type === type)?.value;
  return `${part("year")}-${part("month")}-${part("day")}`;
}

export function formatCep(value: string): string {
  const digits = value.replace(/\D/g, "").slice(0, 8);
  return digits.length > 5 ? `${digits.slice(0, 5)}-${digits.slice(5)}` : digits;
}

export function validateQuote(values: QuoteValues, today = todayInSaoPaulo()): QuoteErrors {
  const errors: QuoteErrors = {};
  if (values.name.trim().length < 2) errors.name = "Informe seu nome com pelo menos 2 caracteres.";

  if (values.channel === "email") {
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(values.contact.trim())) {
      errors.contact = "Informe um e-mail válido.";
    }
  } else if (!/^(?:55)?\d{10,11}$/.test(values.contact.replace(/\D/g, ""))) {
    errors.contact = "Informe um telefone com DDD, com 10 ou 11 dígitos.";
  }

  if (values.origin.replace(/\D/g, "").length !== 8) {
    errors.origin = "Informe o CEP de origem com 8 dígitos.";
  }

  const storageOnly = values.services.length === 1 && values.services[0] === "armazenagem";
  if ((!storageOnly || values.destination.trim()) && values.destination.replace(/\D/g, "").length !== 8) {
    errors.destination = "Informe o CEP de destino com 8 dígitos.";
  }

  if (!values.dateUnknown) {
    const parsedDate = new Date(`${values.date}T12:00:00Z`);
    const validDate = /^\d{4}-\d{2}-\d{2}$/.test(values.date)
      && !Number.isNaN(parsedDate.valueOf())
      && parsedDate.toISOString().slice(0, 10) === values.date;
    if (!validDate) errors.date = "Escolha uma data ou marque “Ainda não sei”.";
    else if (values.date < today) errors.date = "Escolha uma data a partir de hoje.";
  }

  if (!["0", "1", "2", "3", "4", "na"].includes(values.rooms)) {
    errors.rooms = "Selecione o número de quartos ou “Não se aplica”.";
  }
  const knownServices: readonly string[] = services.map((service) => service.id);
  if (!values.services.length || values.services.some((id) => !knownServices.includes(id))) {
    errors.services = "Selecione pelo menos um serviço.";
  }
  return errors;
}
