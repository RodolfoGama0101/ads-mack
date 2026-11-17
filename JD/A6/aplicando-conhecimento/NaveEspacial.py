import pygame
import math
import random
from pathlib import Path


largura = 800
altura = 600


class Asteroide(pygame.sprite.Sprite):
    def __init__(self, area_segura=None):
        super().__init__()
        self.raio = random.randint(12, 36)
        self.image = pygame.Surface((self.raio * 2, self.raio * 2), pygame.SRCALPHA)
        pontos = []
        for indice in range(10):
            angulo = indice * math.tau / 10
            distancia = self.raio * random.uniform(0.75, 0.98)
            pontos.append((self.raio + math.cos(angulo) * distancia,
                           self.raio + math.sin(angulo) * distancia))
        pygame.draw.polygon(self.image, (125, 115, 105), pontos)
        pygame.draw.polygon(self.image, (190, 180, 165), pontos, 2)
        self.mask = pygame.mask.from_surface(self.image)
        self.rect = self.image.get_rect()

        while True:
            self.rect.center = (random.randint(self.raio, largura - self.raio),
                                random.randint(self.raio, altura - self.raio))
            if area_segura is None or not self.rect.colliderect(area_segura):
                break
        self.posicao = pygame.Vector2(self.rect.center)
        self.speed = random.uniform(50, 160)
        self.velocidade = pygame.Vector2(1, 0).rotate(random.uniform(0, 360)) * self.speed
        self.dano = max(10, self.raio // 2)

    def update(self, dt):
        self.posicao += self.velocidade * dt
        if self.posicao.x < -self.raio:
            self.posicao.x = largura + self.raio
        elif self.posicao.x > largura + self.raio:
            self.posicao.x = -self.raio
        if self.posicao.y < -self.raio:
            self.posicao.y = altura + self.raio
        elif self.posicao.y > altura + self.raio:
            self.posicao.y = -self.raio
        self.rect.center = (round(self.posicao.x), round(self.posicao.y))


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
        self.mask = pygame.mask.from_surface(self.image)

    def receber_dano(self, dano):
        dano_no_escudo = min(self.shield, dano)
        self.shield -= dano_no_escudo
        self.energy = max(0, self.energy - (dano - dano_no_escudo))
        if self.shield == 0:
            self.alive = "morto"

    def atirar(self):
        if self.energy == 0:
            return None
        self.energy -= 1
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
        self.mask = pygame.mask.from_surface(self.image)

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
    asteroides = pygame.sprite.Group()
    for _ in range(6):
        asteroides.add(Asteroide(nave.rect.inflate(100, 100)))
    fonte = pygame.font.Font(None, 26)
    fonte_titulo = pygame.font.Font(None, 48)
    tempo_sobrevivido = 0.0
    tempo_geracao = 0.0
    total_tiros = 0
    pontuacao = 0
    rodando = True

    while rodando:
        dt = min(clock.tick(60) / 1000, 0.05)
        disparar = False

        for evento in pygame.event.get():
            if evento.type == pygame.QUIT:
                rodando = False
            elif evento.type == pygame.KEYDOWN and evento.key == pygame.K_SPACE:
                disparar = True
            elif evento.type == pygame.KEYDOWN and evento.key == pygame.K_r and nave.alive == "morto":
                nave = NaveEspacial("Super Nave")
                grupo_nave = pygame.sprite.Group(nave)
                tiros.empty()
                asteroides.empty()
                for _ in range(6):
                    asteroides.add(Asteroide(nave.rect.inflate(100, 100)))
                tempo_sobrevivido = 0.0
                tempo_geracao = 0.0
                total_tiros = 0
                pontuacao = 0

        if not rodando:
            break

        if nave.alive == "vivo":
            tempo_sobrevivido += dt
            tempo_geracao += dt
            nave.mover()
            if disparar:
                tiro = nave.atirar()
                if tiro is not None:
                    tiros.add(tiro)
                    total_tiros += 1
            tiros.update()
            asteroides.update(dt)
            if tempo_geracao >= 1.5:
                tempo_geracao -= 1.5
                if len(asteroides) < 18:
                    asteroides.add(Asteroide(nave.rect.inflate(100, 100)))

            colisoes = pygame.sprite.spritecollide(nave, asteroides, True,
                                                   pygame.sprite.collide_mask)
            for asteroide in colisoes:
                nave.receber_dano(asteroide.dano)
            acertos = pygame.sprite.groupcollide(tiros, asteroides, True, True,
                                                 pygame.sprite.collide_mask)
            pontuacao += sum(len(atingidos) for atingidos in acertos.values()) * 10

        tela.fill((0, 0, 0))
        tiros.draw(tela)
        asteroides.draw(tela)
        grupo_nave.draw(tela)
        for indice, (nome, valor, cor) in enumerate([
            ("Escudo", nave.shield, (60, 160, 255)),
            ("Energia", nave.energy, (70, 210, 110)),
        ]):
            y = 12 + indice * 28
            tela.blit(fonte.render(f"{nome}: {valor}", True, (255, 255, 255)), (12, y))
            pygame.draw.rect(tela, (50, 50, 50), (145, y, 100, 18))
            pygame.draw.rect(tela, cor, (145, y, valor, 18))
        tela.blit(fonte.render(f"Tempo: {tempo_sobrevivido:.1f}s", True, (255, 255, 255)),
                  (largura - 170, 12))
        tela.blit(fonte.render(f"Tiros: {total_tiros}", True, (255, 255, 255)),
                  (largura - 170, 40))
        tela.blit(fonte.render(f"Pontuacao: {pontuacao}", True, (255, 255, 255)),
                  (largura - 170, 68))
        tela.blit(fonte.render("Setas: mover | Espaco: atirar", True, (200, 200, 200)),
                  (12, altura - 28))
        if nave.alive == "morto":
            titulo = fonte_titulo.render("Fim de jogo", True, (255, 100, 100))
            reiniciar = fonte.render("Pressione R para reiniciar", True, (255, 255, 255))
            tela.blit(titulo, titulo.get_rect(center=(largura // 2, altura // 2)))
            tela.blit(reiniciar, reiniciar.get_rect(center=(largura // 2, altura // 2 + 40)))
        pygame.display.update()

    pygame.quit()


if __name__ == "__main__":
    main()
