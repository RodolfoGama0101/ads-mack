import Image from "next/image";
import { ArrowIcon, ArrowUpRightIcon, BoxIcon, CheckIcon } from "./icons";

export function Hero() {
  return (
    <section className="hero container" aria-labelledby="hero-title" id="inicio">
      <div className="hero-grid">
        <div className="hero-copy">
          <p className="eyebrow"><span className="orange-rule" />Mudanças residenciais</p>
          <h1 id="hero-title"><span>Uma mudança</span><span>rápida e</span><span className="orange-text">fácil.</span></h1>
          <p className="hero-description">Você cuida do novo começo.<br />Encontre apoio para transportar, embalar<br className="desktop-break" /> e guardar tudo o que faz parte da sua vida.</p>
          <div className="hero-actions">
            <a href="#orcamento" className="button button-orange">Pedir orçamento grátis<ArrowUpRightIcon /></a>
            <a href="#servicos" className="text-link">Ver serviços<ArrowIcon /></a>
          </div>
          <p className="hero-note"><CheckIcon width="16" height="16" />Comece a planejar, sem compromisso.</p>
        </div>
        <figure className="hero-visual">
          <Image src="/images/hero-v2.webp" alt="Imagem ilustrativa de profissionais levando um sofá protegido para uma nova casa." fill sizes="(max-width: 767px) calc(100vw - 40px), (max-width: 1240px) 48vw, 600px" preload className="hero-image" />
          <span className="photo-corner" aria-hidden="true"><ArrowUpRightIcon width="34" height="34" /></span>
          <figcaption className="hero-caption"><BoxIcon /><span>Da primeira caixa<br /><strong>ao seu novo endereço.</strong></span></figcaption>
        </figure>
      </div>
      <div className="benefits" role="group" aria-label="O que você pode planejar aqui">
        <div><span className="benefit-number">01</span><p>Transporte para<br /><strong>um novo endereço</strong></p></div>
        <div><span className="benefit-number">02</span><p>Apoio com embalagem<br /><strong>e armazenagem</strong></p></div>
        <div><span className="benefit-number">03</span><p>Um pedido de orçamento<br /><strong>sem compromisso</strong></p><ArrowIcon className="benefit-arrow" /></div>
      </div>
    </section>
  );
}
