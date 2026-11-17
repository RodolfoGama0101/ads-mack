import { faqs } from "@/lib/site-content";
import { PlusIcon } from "./icons";

export function Faq() {
  return (
    <section className="faq-section section container" id="duvidas" aria-labelledby="faq-title">
      <div className="faq-heading"><p className="section-label"><span>04</span> Dúvidas frequentes</p><h2 id="faq-title">Antes de<br />dar o próximo passo.</h2><p>Algumas respostas para<br />começar com mais clareza.</p></div>
      <div className="faq-list">{faqs.map((faq) => <details key={faq.question}><summary>{faq.question}<PlusIcon /></summary><p>{faq.answer}</p></details>)}</div>
    </section>
  );
}
