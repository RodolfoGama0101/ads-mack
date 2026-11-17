export const services = [
  {
    id: "interurbana",
    number: "01",
    title: "Mudança interurbana",
    shortTitle: "Interurbana",
    description: "Um novo endereço em outra cidade. Apoio para levar seus móveis até lá.",
    image: "/images/hero-v2.webp",
    imageAlt: "Cena ilustrativa de dois profissionais transportando um sofá protegido.",
  },
  {
    id: "interestadual",
    number: "02",
    title: "Mudança interestadual",
    shortTitle: "Interestadual",
    description: "Para quando o próximo capítulo começa em outro estado.",
    image: "/images/transport.webp",
    imageAlt: "Cena ilustrativa de um caminhão de mudança sendo carregado com caixas.",
  },
  {
    id: "armazenagem",
    number: "03",
    title: "Armazenagem",
    shortTitle: "Armazenagem",
    description: "Um espaço para seus bens entre a saída e a chegada à nova casa.",
    image: "/images/storage.webp",
    imageAlt: "Cena ilustrativa de caixas e móveis protegidos em um espaço de armazenagem.",
  },
  {
    id: "embalagem",
    number: "04",
    title: "Empacotamento e desempacotamento",
    shortTitle: "Embalagem",
    description: "Apoio para proteger seus objetos e organizar a chegada.",
    image: "/images/packing.webp",
    imageAlt: "Cena ilustrativa de mãos embalando uma peça de cerâmica com papel protetor.",
  },
] as const;

export type ServiceId = (typeof services)[number]["id"];

export const quoteSteps = [
  {
    number: "01",
    title: "Conte para onde vai",
    description: "Informe origem, destino e quais serviços fazem sentido para você.",
  },
  {
    number: "02",
    title: "Escolha os detalhes",
    description: "Adicione a data estimada, o número de quartos e seu contato.",
  },
  {
    number: "03",
    title: "Confira seu pedido",
    description: "Nesta versão acadêmica, você pode simular o pedido sem enviar dados.",
  },
] as const;

export const faqs = [
  {
    question: "O pedido de orçamento é gratuito?",
    answer: "Sim. A proposta desta página é permitir um pedido de orçamento gratuito. Nesta versão acadêmica, o formulário apenas simula esse pedido e não realiza contratação.",
  },
  {
    question: "Posso escolher mais de um serviço?",
    answer: "Sim. Você pode combinar transporte, armazenagem e embalagem no mesmo pedido. Selecione os serviços que fazem sentido para sua mudança.",
  },
  {
    question: "Preciso saber a data exata da mudança?",
    answer: "Não. Você pode informar uma data estimada ou selecionar a opção “Ainda não sei”. Assim, pode começar a planejar mesmo sem ter tudo definido.",
  },
  {
    question: "O formulário confirma a reserva da mudança?",
    answer: "Não. Um pedido de orçamento não confirma reserva, preço ou disponibilidade. Esta página é um projeto acadêmico: nenhum pedido é enviado e os dados preenchidos não são armazenados.",
  },
] as const;
