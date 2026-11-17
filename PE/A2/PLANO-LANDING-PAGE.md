# Plano da landing page — Mãos na Mudança

## 1. Objetivo e leitura do material

Criar uma landing page em Next.js, responsiva e em português, que apresente uma proposta de mudança residencial sem complicação e transforme o interesse do visitante em um pedido de orçamento.

Fonte analisada: as três páginas de `Landing Page - Validacao de Ideias.pdf`, incluindo as imagens do template. O material é um estudo acadêmico de uma página Wix, não um cadastro verificado de uma empresa em operação. Este documento registra o planejamento usado na implementação. A aplicação Next.js está na pasta; instruções em `README.md`.

| Evidência no PDF | Decisão para a landing page |
| --- | --- |
| Página 1: promessa de mudança rápida, fácil e segura | Comunicar tranquilidade e conveniência na primeira tela. |
| Página 1: famílias como público principal | Priorizar mudanças residenciais; transferências profissionais e armazenagem entram como necessidades complementares. |
| Página 1: São Paulo e região inferidos a partir do template | Tratar a região de atendimento como informação a confirmar antes de publicar uma oferta real. |
| Páginas 1–2: quatro serviços | Apresentar mudança interurbana, interestadual, armazenagem e empacotamento/desempacotamento. |
| Página 2: orçamento online e telefone | Manter orçamento como ação principal e contato como alternativa, quando houver número real. |
| Página 2: confiança, depoimentos e selos | Explicar o pedido de orçamento e publicar somente evidências verificadas. |
| Página 3: landing page como MVP | Preparar a medição de interesse e a coleta dos dados necessários para testar as hipóteses. |

Os valores de 1.000 visitantes, 150 cliques, 60 orçamentos e 12 vendas são explicitamente ilustrativos. Não serão usados como resultados da empresa ou metas comprovadas. “Garantia total” e “100% confiável” também não serão reproduzidos como compromissos reais sem confirmação. Nomes e RAs dos integrantes pertencem ao trabalho acadêmico, não à página comercial.

## 2. Direção visual com frontend-design

**Âncora: Swiss.** A composição editorial dá presença à proposta de tranquilidade, com informação fácil de escanear e identidade próxima do laranja, branco e preto do material. A página terá uma única direção, sem misturar estilos.

**Diferencial:** uma linha laranja conecta visualmente os campos reais de origem e destino no bloco de orçamento. Esse mesmo alinhamento organiza o hero e as seções, associando a ideia de deslocamento ao principal ponto de conversão.

| Token | Especificação |
| --- | --- |
| Superfície principal | Branco `#FFFFFF`. |
| Superfície secundária | Neutro `#F7F7F8`. |
| Texto principal | Preto `#111111`. |
| Texto secundário | Cinza `#555555`. |
| Única cor de destaque | International Orange `#FF4F00`. |
| Divisórias | Linhas de 1 px em cinza neutro. |
| Tipografia | `Helvetica Neue`, com `Helvetica` e `Arial` como alternativas; mesma família em títulos e corpo. |
| Composição | Grid visível por alinhamentos e divisórias, assimetria equilibrada e texto à esquerda. |
| Controles | Formas retas, sem sombras decorativas; foco visível e estados de erro legíveis. |
| Movimento | Transições discretas; respeitar preferência por movimento reduzido. |

Usar texto preto sobre o botão laranja para favorecer a legibilidade; conferir contraste na implementação. Não usar fundos em creme, fontes serifadas, granulação, títulos centralizados, gradientes ou blocos decorativos sem informação.

A pedido do usuário, as fotografias foram criadas com o gerador integrado de imagens do ChatGPT e otimizadas em WebP. São cenas ilustrativas de transporte, embalagem e armazenagem; os prompts estão em `docs/IMAGE-PROMPTS.md`. As capturas do Wix no PDF servem como referência, não como assets da página. Vídeo fica fora da primeira versão para reduzir custo de carregamento no celular.

## 3. Estrutura e conteúdo proposto

### Cabeçalho

- Nome “Mãos na Mudança” como marca textual provisória.
- Links internos: “Serviços”, “Como solicitar” e “Dúvidas”.
- Botão principal: “Pedir orçamento grátis”, direcionado para `#orcamento`.
- Contato secundário somente com telefone confirmado.

### Primeira dobra

**Título:** “Uma mudança rápida e fácil.”

**Texto de apoio:** “Do planejamento à chegada, encontre apoio para transportar, embalar e guardar seus móveis.”

**CTA:** “Pedir orçamento grátis”. **Ação secundária:** “Ver serviços”.

Texto grande à esquerda e fotografia à direita no desktop. No celular, a promessa e o CTA aparecem antes da imagem. A redação é uma proposta de posicionamento; a oferta precisa corresponder aos serviços efetivamente disponíveis antes de uso comercial.

### Serviços — `#servicos`

Quatro blocos com nome, descrição curta e link “Incluir no orçamento”. Esse link seleciona o serviço no formulário e leva o visitante até ele.

| Serviço | Descrição proposta |
| --- | --- |
| Mudança interurbana | Para quem está planejando mudar de uma cidade para outra. |
| Mudança interestadual | Para quem precisa levar seus móveis para outro estado. |
| Armazenagem | Para quem precisa guardar seus bens entre uma etapa e outra. |
| Empacotamento e desempacotamento | Para quem quer apoio na preparação e organização dos objetos. |

Não criar páginas “Leia mais” sem conteúdo. Uma observação sobre disponibilidade pode ser incluída quando a cobertura real estiver definida.

### Como solicitar — `#como-solicitar`

Três etapas do próprio fluxo, sem presumir procedimentos operacionais da empresa:

1. Informe origem, destino e os serviços desejados.
2. Escolha uma data estimada e informe como prefere receber contato.
3. Envie o pedido para análise, quando a integração real estiver disponível.

Explicar que o envio solicita um orçamento e não confirma reserva ou preço. Depoimentos podem entrar depois desta seção se forem fornecidos com autorização e origem verificável; na primeira versão, a seção pode ser omitida.

### Pedido de orçamento — `#orcamento`

Título: “Vamos planejar sua mudança?”

Formulário curto, com todos os rótulos visíveis:

- Nome.
- E-mail ou telefone: escolher um canal e informar apenas o contato correspondente.
- CEP de origem e CEP de destino; permitir ausência de destino quando o pedido for apenas de armazenagem.
- Data estimada, com opção “Ainda não sei”.
- Número de quartos, com opção “Não se aplica”.
- Serviços desejados, permitindo mais de uma escolha.

Botão: “Solicitar orçamento grátis”. Sem campo de mensagem obrigatório, cadastro de conta ou perguntas adicionais na primeira versão.

Validar campos pertinentes ao serviço, formato de contato, oito dígitos do CEP e data futura quando informada. Mostrar erros próximos dos campos, manter os valores em caso de falha e impedir envio duplicado enquanto a solicitação estiver em andamento.

O sucesso só aparece depois de uma confirmação real do servidor. Não dizer que um e-mail foi enviado ou que alguém retornará em determinado prazo sem integração e compromisso operacional definidos.

**Modo acadêmico inicial:** aviso visível “Projeto acadêmico: simulação de pedido de orçamento.” O formulário pode demonstrar validação, mas não transmitir nem persistir dados pessoais. A confirmação dirá “Simulação concluída. Nenhum pedido foi enviado.” Não haverá coleta silenciosa ou sucesso fictício.

### Dúvidas — `#duvidas`

Perguntas sobre a gratuidade do pedido, dados necessários e diferença entre solicitação e reserva. Usar elementos nativos `details`/`summary`. Respostas sobre preços, seguros, prazos e cobertura aguardam informações reais.

### Rodapé

Marca, navegação útil e identificação do projeto acadêmico. Em uso comercial, incluir contato, região de atendimento e política de privacidade reais. Endereço, licença, horário, associações e chat só aparecem quando fornecidos e comprovados.

## 4. Responsividade e acessibilidade

Implementar a partir do mobile, com conteúdo em uma coluna e margens de 16–24 px. A partir de aproximadamente 768 px, serviços e formulário podem usar duas colunas; no desktop, hero em duas colunas e conteúdo limitado a cerca de 1.200 px. Ajustar os pontos de quebra conforme o conteúdo, sem depender de um modelo específico de aparelho.

No celular, manter marca e CTA no cabeçalho e oferecer links num menu acessível apenas se necessário. Evitar uma barra inferior fixa na primeira versão para não cobrir o formulário ou disputar espaço com o teclado. O cabeçalho pode permanecer visível com altura compacta e `scroll-margin-top` nas seções.

- Títulos fluidos com `clamp`, sem ultrapassar a largura da tela.
- Alvos de toque de pelo menos 44 px e fontes de formulário de pelo menos 16 px.
- Origem e destino empilhados no mobile, preservando a linha laranja do diferencial.
- Teclados apropriados para telefone, e-mail e CEP; preenchimento automático quando aplicável.
- Navegação completa por teclado, link para pular ao conteúdo e foco visível.
- HTML semântico, um único `h1`, rótulos associados aos campos e anúncio acessível do resultado.
- Imagens com descrição adequada e proporções reservadas para evitar deslocamento de layout.
- Sem carrossel automático ou animações necessárias para entender o conteúdo.

## 5. Arquitetura em Next.js

Usar **Next.js com App Router, TypeScript e CSS**, com tokens em CSS custom properties. A versão suportada será escolhida e fixada no início da implementação. Não é necessário adicionar biblioteca visual, gerenciador global de estado ou CMS para este escopo.

Estrutura proposta:

```text
app/
  layout.tsx                 # idioma pt-BR e metadados
  page.tsx                   # composição da landing page
  globals.css                # tokens, grid e estilos responsivos
components/
  header.tsx
  hero.tsx
  services.tsx
  quote-steps.tsx
  quote-form.tsx             # componente cliente: seleção e validação
  faq.tsx
  footer.tsx
lib/
  site-content.ts            # conteúdo, serviços e dados confirmados
  quote-validation.ts       # regras reutilizáveis do formulário
public/
  images/                   # imagens licenciadas e otimizadas
```

As seções de conteúdo ficam renderizadas no servidor; somente o formulário, o menu mobile quando necessário e as interações recebem JavaScript no cliente. Usar `next/image` para imagens locais, metadados próprios e ícones SVG consistentes somente quando ajudarem a interação.

Para captura real, adicionar um endpoint no servidor ou Server Action com validação própria e um destino definido para os pedidos. A escolha entre caixa de e-mail, CRM ou armazenamento depende de como o responsável pretende responder. Credenciais ficam no servidor; falhas precisam preservar o formulário e permitir nova tentativa. Prever proteção contra abuso antes de habilitar coleta pública.

## 6. Plano de validação da ideia

Medir comportamento somente na versão publicada com configuração real de analytics. O modo acadêmico não envia eventos a terceiros por padrão.

| Evento | Quando acontece | O que ajuda a avaliar |
| --- | --- | --- |
| `page_view` | Visita à página | Base de visitas do experimento. |
| `quote_cta_click` | Clique para o formulário | Interesse inicial; registrar a posição do CTA. |
| `service_select` | Inclusão de um serviço | Preferência entre os serviços propostos. |
| `quote_form_start` | Primeira interação com o formulário | Início efetivo da solicitação. |
| `quote_submit_success` | Pedido aceito pelo servidor | Conversão em lead real. |
| `quote_submit_error` | Falha de envio | Fricção técnica, sem registrar dados pessoais. |
| `contact_click` | Clique em contato real | Uso do canal alternativo, sem presumir conversa ou venda. |

Indicadores: visitas com clique no CTA / visitas; visitas com pedido aceito / visitas; pedidos aceitos / inícios de formulário. Deduplicar as visitas que executam cada ação e manter a mesma janela de observação. Como um pedido pode incluir vários serviços, as participações por serviço não precisam somar 100%.

Não colocar nome, contato ou CEP completo nos eventos. As informações necessárias para responder ao pedido pertencem à captura de leads, com finalidade e acesso definidos. Conversão em venda exige registro posterior no processo comercial: clique e formulário não comprovam venda.

Hipóteses a observar: quais serviços despertam mais interesse, quantos visitantes concluem o pedido e qual canal preferem. Comparar mais adiante a promessa original com “Sua mudança com menos preocupação”, alterando uma variável por experimento e definindo critérios antes de avaliar o resultado. As taxas ilustrativas do PDF não serão adotadas como limiares de sucesso.

## 7. Sequência de execução e critérios de aceite

1. Criar o projeto Next.js e configurar TypeScript, scripts e tokens Swiss.
2. Implementar conteúdo, hero e navegação; conferir primeiro a largura mobile.
3. Implementar seleção de serviços, formulário e estados do modo acadêmico.
4. Inserir fotografia adequada, revisar contraste, foco, teclado e textos.
5. Verificar tipos e build; revisar visualmente em 360, 390, 768, 1.024 e 1.440 px.
6. Quando houver dados e destino de captura, conectar o envio real e analytics, revisar sucesso e falha de ponta a ponta e preparar publicação.

Aceite: sem rolagem horizontal, textos legíveis, CTA levando ao formulário sem campo oculto pelo cabeçalho, seleção de serviço preservada, erros compreensíveis, envio duplicado impedido e confirmação coerente com o modo de funcionamento. No modo acadêmico, não há pedidos ou dados pessoais enviados. Na versão real, testar aceitação e falha do endpoint e confirmar que os eventos não contêm dados pessoais.

## 8. Informações que faltam para uso comercial

O plano permite iniciar uma versão acadêmica completa. Para transformá-la em oferta comercial, faltam: identificação e contato da empresa, cobertura e serviços disponíveis, imagem licenciada, destino dos pedidos, conteúdo de privacidade e eventuais provas de confiança. Nenhum desses dados será inventado a partir do template Wix.

Entregáveis da implementação: código Next.js, landing page mobile e desktop, formulário com estados claros, instruções para executar e configurar o projeto e resultado das verificações. Publicação e integração comercial são etapas posteriores à versão local.
