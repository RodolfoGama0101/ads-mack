import type { Metadata, Viewport } from "next";
import "./globals.css";

export const metadata: Metadata = {
  title: "Mãos na Mudança | Seu próximo endereço, um novo começo",
  description: "Planeje sua mudança residencial. Conheça as propostas de transporte, armazenagem e embalagem e simule um pedido de orçamento gratuito. Projeto acadêmico.",
  robots: { index: false, follow: false },
  openGraph: {
    title: "Mãos na Mudança | Uma mudança rápida e fácil",
    description: "Seu próximo endereço. Um novo começo. Conheça os serviços e planeje sua mudança nesta demonstração acadêmica.",
    locale: "pt_BR",
    type: "website",
  },
};

export const viewport: Viewport = { themeColor: "#FFFFFF" };

export default function RootLayout({ children }: Readonly<{ children: React.ReactNode }>) {
  return <html lang="pt-BR"><body><a href="#conteudo" className="skip-link">Pular para o conteúdo</a>{children}</body></html>;
}
