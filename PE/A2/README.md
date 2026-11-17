# Mãos na Mudança

Landing page responsiva em Next.js, React e TypeScript, desenvolvida a partir do PDF da atividade de Projetos Empreendedores. A direção visual Swiss segue a skill frontend-design: branco, tipografia Helvetica/Arial, grid e divisórias finas, com destaque laranja `#FF4F00`.

## Executar

Requer Node.js 20.9 ou superior e npm, conforme os [requisitos do Next.js](https://nextjs.org/docs/app/getting-started/installation). Dependências fixadas em `package-lock.json`.

```sh
npm ci
npm run dev
```

Abra http://localhost:3000. Para uma versão de produção local:

```sh
npm run build
npm start
```

## Verificar

```sh
npm run typecheck
npm test
npm run build
```

Os testes de validação usam o suporte nativo do Node para TypeScript. Para executar `npm test`, use Node.js 22.18 ou superior; o desenvolvimento e build seguem os requisitos do Next.js.

## Conteúdo e imagens

- Textos, serviços, etapas e perguntas: `lib/site-content.ts`.
- Estilos e pontos de quebra: `app/globals.css`.
- Regras do formulário: `lib/quote-validation.ts`.
- Fotografias ilustrativas criadas com o gerador integrado de imagens do ChatGPT: `public/images/hero-v2.webp`, `transport.webp`, `packing.webp` e `storage.webp`. A versão `hero-v2.webp` corrige a mão do profissional; o original `hero.webp` foi preservado.
- Prompts finais e informações de geração: `docs/IMAGE-PROMPTS.md`.
- Análise do PDF e planejamento: `PLANO-LANDING-PAGE.md`.

Não há fontes, fotografias ou scripts carregados de serviços externos. As imagens são ilustrativas e não representam uma equipe ou estrutura comercial real.

## Formulário acadêmico

O formulário valida os dados no navegador e mostra um resumo da simulação. Não realiza requisições para enviar os campos, não usa cookies, analytics ou armazenamento local e não grava os dados. A navegação entre serviços e formulário mantém a seleção enquanto a página está aberta. Recarregar a página limpa o preenchimento.

“Incluir no orçamento” seleciona o serviço correspondente. A escolha exclusiva de armazenagem permite omitir o CEP de destino. O visitante pode indicar que ainda não conhece a data, escolher e-mail ou telefone e simular outro pedido após a conclusão.

## Antes de habilitar uma oferta comercial

Substituir a identificação acadêmica por informações verificadas, confirmar serviços e cobertura, definir o destino dos pedidos e implementar captura no servidor com validação e proteção contra abuso. A confirmação deverá depender de uma resposta real da integração. Analytics e política de privacidade precisam ser configurados para esse uso.

O site está marcado como `noindex` enquanto for uma demonstração acadêmica. Não inclui depoimentos, números comerciais ou selos inventados. Não há publicação automática.
