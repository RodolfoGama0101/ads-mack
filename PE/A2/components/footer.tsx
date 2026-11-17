import { ArrowUpRightIcon, BrandMark } from "./icons";

export function Footer() {
  return (
    <footer className="site-footer">
      <div className="container">
        <div className="footer-main"><a className="brand" href="#inicio" aria-label="Mãos na Mudança — voltar ao início"><BrandMark className="brand-mark" /><span>Mãos na<br />Mudança<span className="brand-period">.</span></span></a><p>Seu próximo endereço.<br /><strong>Um novo começo.</strong></p><a href="#inicio" className="text-link">Voltar ao início<ArrowUpRightIcon /></a></div>
        <div className="footer-bottom"><p>Projeto acadêmico · Projetos Empreendedores</p><p>Imagens ilustrativas geradas com IA.<br className="mobile-break" /> Nenhum pedido ou dado pessoal é enviado.</p></div>
      </div>
    </footer>
  );
}
