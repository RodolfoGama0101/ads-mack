import { Header } from "@/components/header";
import { Hero } from "@/components/hero";
import { Services } from "@/components/services";
import { QuoteSteps } from "@/components/quote-steps";
import { QuoteForm } from "@/components/quote-form";
import { Faq } from "@/components/faq";
import { Footer } from "@/components/footer";
import { todayInSaoPaulo } from "@/lib/quote-validation";

export default function Home() {
  return <><Header /><main id="conteudo"><Hero /><Services /><QuoteSteps /><QuoteForm initialToday={todayInSaoPaulo()} /><Faq /></main><Footer /></>;
}
