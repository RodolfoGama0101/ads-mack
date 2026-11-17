# Correção da mão no hero

Ferramenta: gerador integrado de imagens do ChatGPT, em modo de edição.

Entrada: `public/images/hero.webp`. Saída aplicada ao hero e ao card interurbano: `public/images/hero-v2.webp`. A versão anterior foi preservada. O novo nome também evita reutilizar a imagem antiga no cache do Next.js.

Prompt final:

> Use case: precise-object-edit. Edit the provided landing-page photograph. Correct ONLY the visible hand and wrist of the foreground mover on the RIGHT side of the photo, where his near-camera arm reaches the front lower right corner of the wrapped sofa. The current hand has an unnatural orientation and does not convincingly support the sofa. Make this a realistic load-bearing grip: palm supporting the underside of the sofa's lower edge, four naturally proportioned fingers curled beneath the edge and mostly occluded by the sofa, one thumb resting naturally along the near side, anatomically correct wrist connecting smoothly to the existing forearm. Exactly five fingers, realistic knuckles and skin texture, no extra digits, no downward dangling fingers, no flattened or fused fingers. Make any minimal local adjustment to the wrist required for this natural grip; preserve the arm, sleeve, skin tone and body pose. Keep ALL other details unchanged: both men's identities, clothing, sofa shape and wrapping, legs, house, doorway, boxes, foliage, camera framing, daylight, resolution and landscape 3:2 composition. Preserve the original editorial photorealism. No text, logos or watermarks.
