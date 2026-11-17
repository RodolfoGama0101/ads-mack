"use client";

import type { ServiceId } from "@/lib/site-content";
import { ArrowUpRightIcon } from "./icons";

export function ServiceLink({ service, title }: { service: ServiceId; title: string }) {
  return <a href="#orcamento" className="service-link" aria-label={`Incluir ${title.toLowerCase()} no orçamento`} onClick={() => {
    window.dispatchEvent(new CustomEvent("quote:select-service", { detail: service }));
  }}>Incluir no orçamento<ArrowUpRightIcon /></a>;
}
