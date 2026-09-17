import pygame

pygame.init()

class NaveEspacial(pygame.sprite.Sprite):
     
    def __init__(self, name):
        super().__init__()

        self.imagem_original = pygame.Surface((50, 70))
        pygame.draw.polygon(
            self.imagem_original,
            (0, 255, 0),
            [(25, 0), (0, 70), (50, 70)]
        )

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

clock = pygame.time.Clock()

largura = 800
altura = 600

tela = pygame.display.set_mode((largura, altura))
pygame.display.set_caption("Minha Nave Espacial")

nave = NaveEspacial("Super Nave")
grupo_nave = pygame.sprite.Group()
grupo_nave.add(nave)

rodando = True

while rodando: 
    clock.tick(60)

    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:
            rodando = False

    nave.mover()

    tela.fill((0, 0, 0))
    grupo_nave.draw(tela)                
    pygame.display.update()

pygame.quit()

