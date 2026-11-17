import pygame
from pathlib import Path


largura = 800
altura = 600


class Tiro(pygame.sprite.Sprite):

    def __init__(self, posicao):
        super().__init__()
        self.image = pygame.Surface((5, 15))
        self.image.fill((255, 255, 0))
        self.rect = self.image.get_rect(midbottom=posicao)
        self.speed = 12

    def update(self):
        self.rect.y -= self.speed
        if self.rect.bottom <= 0:
            self.kill()


class NaveEspacial(pygame.sprite.Sprite):
     
    def __init__(self, name):
        super().__init__()

        caminho = Path(__file__).with_name("nave.svg")
        self.imagem_original = pygame.image.load(str(caminho)).convert_alpha()

        self.image = self.imagem_original.copy()

        self.rect = self.image.get_rect()
        self.rect.centerx = largura // 2
        self.rect.bottom = altura - 20

        self.name = name
        self.alive = "vivo"
        self.direction = 0
        self.speed = 7
        self.shield = 100
        self.energy = 100

    def atirar(self):
        return Tiro(self.rect.midtop)

    def mover(self): 
        teclas = pygame.key.get_pressed()

        if teclas[pygame.K_LEFT]: 
            self.direction = 90
            self.rect.x -= self.speed

        if teclas[pygame.K_RIGHT]:
            self.direction = 270 
            self.rect.x += self.speed

        if teclas[pygame.K_UP]: 
            self.direction = 0
            self.rect.y -= self.speed

        if teclas[pygame.K_DOWN]:
            self.direction = 180 
            self.rect.y += self.speed

        centro = self.rect.center

        self.image = pygame.transform.rotate(
            self.imagem_original,
            self.direction
        )

        self.rect = self.image.get_rect(center=centro)

        if self.rect.left < 0:
            self.rect.left = 0

        if self.rect.right > largura:
            self.rect.right = largura

        if self.rect.top < 0:
            self.rect.top = 0

        if self.rect.bottom > altura:
            self.rect.bottom = altura

def main():
    pygame.init()
    clock = pygame.time.Clock()
    tela = pygame.display.set_mode((largura, altura))
    pygame.display.set_caption("Minha Nave Espacial")

    nave = NaveEspacial("Super Nave")
    grupo_nave = pygame.sprite.Group(nave)
    tiros = pygame.sprite.Group()
    rodando = True

    while rodando:
        clock.tick(60)
        disparar = False

        for evento in pygame.event.get():
            if evento.type == pygame.QUIT:
                rodando = False
            elif evento.type == pygame.KEYDOWN and evento.key == pygame.K_SPACE:
                disparar = True

        if not rodando:
            break

        nave.mover()
        if disparar:
            tiros.add(nave.atirar())
        tiros.update()

        tela.fill((0, 0, 0))
        tiros.draw(tela)
        grupo_nave.draw(tela)
        pygame.display.update()

    pygame.quit()


if __name__ == "__main__":
    main()

