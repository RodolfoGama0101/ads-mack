# Verificação da landing page

Verificada em 2 de outubro de 2026, em Windows, com Node.js 24.15.0 e navegador Chromium através da skill agent-browser. A versão final foi compilada em modo de produção.

## Resultado

- `npm run build`: aprovado; página principal pré-renderizada pelo Next.js.
- `npm run typecheck`: aprovado.
- `npm test`: 7 testes aprovados, sem falhas.
- Auditoria axe-core 4.12.1 em 390 × 844 e 1440 × 900: 46 verificações aprovadas, zero violações e zero verificações pendentes em cada largura.
- Sem erros de execução relatados pelo navegador.

## Responsividade

Larguras verificadas: 320, 360, 390, 768, 1024 e 1440 px. Nenhuma apresentou rolagem horizontal ou elementos ultrapassando a largura da página. Hero e formulário foram inspecionados visualmente em mobile, tablet e desktop. As seis instâncias de imagem foram carregadas corretamente.

Prévias da versão final: `preview-mobile.png` e `preview-desktop.png` nesta pasta.

## Fluxos conferidos no navegador

- “Incluir no orçamento” seleciona o serviço correto e navega para o formulário.
- Envio vazio mostra erros associados aos campos e coloca o foco no primeiro campo inválido conforme a ordem visual.
- Armazenagem permite destino ausente e data desconhecida; a simulação termina com um resumo coerente.
- Mudança interestadual exige destino; contato por telefone e data definida aparecem corretamente no fluxo e no resumo. A fixture de data foi inserida por evento DOM, pois o comando `fill` do navegador de teste não preencheu o controle nativo de data.
- “Simular outro pedido” limpa o preenchimento e retorna o foco ao nome.
- Menu mobile abre, fecha com Escape e devolve o foco ao botão.
- Cookies, localStorage e sessionStorage permanecem vazios. Nenhuma requisição fetch/XHR foi registrada ao simular o pedido.

## Assets e limites

Quatro imagens foram criadas com a ferramenta integrada de imagens do ChatGPT e convertidas para WebP: `hero-v2.webp`, `transport.webp`, `packing.webp` e `storage.webp`, em `public/images/`. A versão `hero-v2.webp` corrige a mão do profissional no hero e no card de mudança interurbana; o original `hero.webp` foi preservado. Os prompts finais estão em `IMAGE-PROMPTS.md`. As imagens são ilustrativas e não comprovam estrutura, equipe ou operação comercial.

O formulário é uma demonstração acadêmica. Não envia pedidos, não grava dados e não integra e-mail, CRM ou analytics. O site está marcado como `noindex`. Não foi publicado em um serviço externo.

A auditoria automática e a revisão visual não substituem testes com usuários, leitores de tela e aparelhos físicos. As verificações acima descrevem o ambiente efetivamente utilizado.
