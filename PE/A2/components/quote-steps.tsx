import Image from "next/image";
import { quoteSteps } from "@/lib/site-content";
import { ArrowUpRightIcon } from "./icons";

export function QuoteSteps() {
  return (
    <section className="process-section" id="como-solicitar" aria-labelledby="process-title">
      <div className="container process-grid">
        <div className="process-visual">
          <div className="process-photo"><Image src="/images/packing.webp" alt="Imagem ilustrativa do cuidado ao embalar um objeto para a mudança." fill sizes="(max-width: 767px) calc(100vw - 40px), 44vw" /></div>
          <p className="photo-caption"><span className="orange-rule" />Os detalhes também fazem parte da mudança.</p>
        </div>
        <div className="process-copy">
          <p className="section-label"><span>02</span> Como solicitar</p>
          <h2 id="process-title">Seu novo começo.<br />Um passo de cada vez.</h2>
          <p className="process-intro">Planejar uma mudança já tem decisões suficientes.<br className="desktop-break" /> O primeiro passo por aqui é simples.</p>
          <ol className="process-steps">{quoteSteps.map((step) => <li key={step.number}><span className="step-number">{step.number}</span><div><h3>{step.title}</h3><p>{step.description}</p></div></li>)}</ol>
          <a href="#orcamento" className="text-link">Começar meu planejamento<ArrowUpRightIcon /></a>
        </div>
      </div>
    </section>
  );
}
