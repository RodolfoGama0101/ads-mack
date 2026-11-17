import assert from "node:assert/strict";
import test from "node:test";
import { formatCep, todayInSaoPaulo, validateQuote, type QuoteValues } from "../lib/quote-validation.ts";

const validQuote: QuoteValues = {
  name: "Pessoa de teste", channel: "email", contact: "teste@example.com",
  origin: "01001-000", destination: "13010-000", date: "2026-10-20",
  dateUnknown: false, rooms: "2", services: ["interurbana"],
};
const today = "2026-10-02";

test("a solicitação completa aceita múltiplos serviços", () => {
  assert.deepEqual(validateQuote({ ...validQuote, services: ["interurbana", "embalagem"] }, today), {});
});

test("armazenagem permite destino ausente, transporte combinado exige destino", () => {
  assert.deepEqual(validateQuote({ ...validQuote, services: ["armazenagem"], destination: "" }, today), {});
  assert.ok(validateQuote({ ...validQuote, services: ["armazenagem", "interestadual"], destination: "" }, today).destination);
  assert.ok(validateQuote({ ...validQuote, services: ["armazenagem"], destination: "123" }, today).destination);
});

test("data desconhecida é aceita sem data; passado e datas inexistentes são rejeitados", () => {
  assert.deepEqual(validateQuote({ ...validQuote, dateUnknown: true, date: "" }, today), {});
  assert.ok(validateQuote({ ...validQuote, date: "2026-10-01" }, today).date);
  assert.ok(validateQuote({ ...validQuote, date: "2026-02-30" }, "2026-01-01").date);
  assert.deepEqual(validateQuote({ ...validQuote, date: today }, today), {});
});

test("contato telefônico aceita DDD e código brasileiro, sem aceitar contato incompleto", () => {
  assert.deepEqual(validateQuote({ ...validQuote, channel: "phone", contact: "+55 (11) 99999-9999" }, today), {});
  assert.ok(validateQuote({ ...validQuote, channel: "phone", contact: "99999-9999" }, today).contact);
  assert.ok(validateQuote({ ...validQuote, contact: "sem-email" }, today).contact);
});

test("solicitação vazia retorna erros por campo e nenhum serviço não reconhecido é aceito", () => {
  const errors = validateQuote({ ...validQuote, name: " ", origin: "", services: [] }, today);
  assert.ok(errors.name);
  assert.ok(errors.origin);
  assert.ok(errors.services);
  assert.ok(validateQuote({ ...validQuote, services: ["inexistente" as never] }, today).services);
});

test("data de referência segue São Paulo na virada do dia em UTC", () => {
  assert.equal(todayInSaoPaulo(new Date("2026-10-03T01:00:00Z")), "2026-10-02");
});

test("CEP é formatado sem perder zeros e é limitado a oito dígitos", () => {
  assert.equal(formatCep("01001000"), "01001-000");
  assert.equal(formatCep("01001-000999"), "01001-000");
});
