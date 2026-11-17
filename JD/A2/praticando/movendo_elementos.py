"""Exercício 1: movimente o tanque usando as setas do teclado."""

import pygame


LARGURA, ALTURA = 800, 600
VELOCIDADE = 5


def criar_tanque() -> pygame.Surface:
    tanque = pygame.Surface((80, 50), pygame.SRCALPHA)
    pygame.draw.rect(tanque, (45, 110, 50), (8, 15, 64, 27), border_radius=6)
    pygame.draw.circle(tanque, (30, 80, 35), (40, 28), 16)
    pygame.draw.rect(tanque, (30, 80, 35), (40, 23, 35, 8))
    pygame.draw.circle(tanque, (20, 20, 20), (22, 43), 7)
    pygame.draw.circle(tanque, (20, 20, 20), (58, 43), 7)
    return tanque


pygame.init()
tela = pygame.display.set_mode((LARGURA, ALTURA))
pygame.display.set_caption("Tanque - setas direcionais")
relogio = pygame.time.Clock()

tanque = criar_tanque()
retangulo_tanque = tanque.get_rect(center=(LARGURA // 2, ALTURA // 2))
executando = True

while executando:
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            executando = False

    teclas = pygame.key.get_pressed()
    if teclas[pygame.K_LEFT]:
        retangulo_tanque.x -= VELOCIDADE
    if teclas[pygame.K_RIGHT]:
        retangulo_tanque.x += VELOCIDADE
    if teclas[pygame.K_UP]:
        retangulo_tanque.y -= VELOCIDADE
    if teclas[pygame.K_DOWN]:
        retangulo_tanque.y += VELOCIDADE

    retangulo_tanque.clamp_ip(tela.get_rect())
    tela.fill((255, 255, 255))
    tela.blit(tanque, retangulo_tanque)
    pygame.display.flip()
    relogio.tick(60)

pygame.quit()
