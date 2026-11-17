"use client";

import { useState } from "react";
import { ArrowUpRightIcon, BrandMark } from "./icons";

const links = [
  { href: "#servicos", label: "Serviços" },
  { href: "#como-solicitar", label: "Como solicitar" },
  { href: "#duvidas", label: "Dúvidas" },
];

export function Header() {
  const [open, setOpen] = useState(false);

  return (
    <header className="site-header" onKeyDown={(event) => {
      if (event.key === "Escape") {
        setOpen(false);
        document.getElementById("menu-toggle")?.focus();
      }
    }}>
      <div className="container header-inner">
        <a href="#inicio" className="brand" aria-label="Mãos na Mudança — início" onClick={() => setOpen(false)}>
          <BrandMark className="brand-mark" />
          <span>Mãos na<br />Mudança<span className="brand-period">.</span></span>
        </a>
        <nav className="desktop-nav" aria-label="Navegação principal">
          {links.map((link) => <a href={link.href} key={link.href}>{link.label}</a>)}
        </nav>
        <div className="header-actions">
          <a className="button button-orange header-cta" href="#orcamento" onClick={() => setOpen(false)}>
            <span>Orçamento grátis</span><ArrowUpRightIcon />
          </a>
          <button id="menu-toggle" type="button" className={`menu-toggle ${open ? "is-open" : ""}`} aria-expanded={open} aria-controls="mobile-nav" aria-label={open ? "Fechar menu" : "Abrir menu"} onClick={() => setOpen(!open)}>
            <span /><span />
          </button>
        </div>
      </div>
      <nav id="mobile-nav" className="mobile-nav" aria-label="Navegação mobile" hidden={!open}>
        <div className="container">
          {links.map((link) => <a href={link.href} key={link.href} onClick={() => setOpen(false)}>{link.label}<ArrowUpRightIcon /></a>)}
        </div>
      </nav>
    </header>
  );
}
