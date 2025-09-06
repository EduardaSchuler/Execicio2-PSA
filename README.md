# Execicio2-PSA
Exercicio 2 da disciplina de programação de software aplicado

testes:
POST /auth/login
{
  "username": "admin",
  "password": "admin123"
}

GET /api/admin
Authorization: Bearer <token-do-admin>

resposta esperada: Hello, admin!

Se você acessar /api/hello ou /api/admin sem Authorization: Bearer ..., receberá:

401 Unauthorized (não autenticado), ou
403 Forbidden (se autenticado, mas sem permissão)

🧠 Conceito por trás
🔐 O que é uma SecretKey?

JWTs assinados com algoritmos como HS256 (HMAC com SHA-256) precisam de uma chave secreta para:

Assinar o token quando ele é criado.

Verificar a assinatura do token quando ele é recebido.

Essa chave é compartilhada entre quem emite e quem valida o token.

✅ O que faz Keys.secretKeyFor(...)?

Esse método faz parte da biblioteca JJWT (io.jsonwebtoken.security.Keys) e tem como objetivo:

Gerar uma chave secreta criptograficamente segura;

Baseada no algoritmo que você indicar (HS256, HS384, HS512, etc);

Retorna um objeto javax.crypto.SecretKey.

✅ Exemplo real de uso
SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

String jwt = Jwts.builder()
    .setSubject("user")
    .signWith(key)
    .compact();


Esse token agora pode ser verificado usando a mesma chave key.

⚠️ Aviso importante

A chave gerada por:

Keys.secretKeyFor(SignatureAlgorithm.HS256)


é aleatória e muda a cada execução do programa.

Isso significa:

Se o seu backend for reiniciado, os tokens emitidos anteriormente não serão mais válidos, pois a chave mudou.