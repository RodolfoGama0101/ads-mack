# Nave espacial com asteroides

Jogo em Pygame: desvie dos asteroides e sobreviva pelo maior tempo possível.

## Como executar

Com Python instalado, execute nesta pasta:

```powershell
python -m pip install -r requirements.txt
python NaveEspacial.py
```

Mantenha `nave.svg` na mesma pasta de `NaveEspacial.py`.

## Controles

- Setas: mover a nave.
- Espaço: disparar e destruir asteroides.
- R: reiniciar após o fim de jogo.
- Fechar a janela: sair.

## Regras

O jogo começa com seis asteroides. A cada 1,5 segundo, surge outro em uma
posição aleatória da tela, até o limite de 18. A área próxima à nave fica
protegida durante o nascimento dos asteroides.

Cada asteroide tem raio entre 12 e 36 pixels, velocidade entre 50 e 160
pixels por segundo e direção aleatória. Ao atravessar uma borda, reaparece
na borda oposta.

A nave começa com 100 pontos de escudo e 100 de energia. Cada colisão
causa entre 10 e 18 pontos de dano, conforme o tamanho do asteroide.
O escudo absorve o dano; o excedente reduz a energia. O asteroide que
colidiu é removido, evitando dano repetido pelo mesmo contato.
Quando a energia chega a zero, a partida termina.
