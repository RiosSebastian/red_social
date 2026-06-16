📱 Social Network API – Spring Boot

API REST backend para una red social inspirada en Instagram / Facebook, desarrollada con Spring Boot, enfocada en seguridad, escalabilidad y buenas prácticas de arquitectura.
Permite gestionar usuarios, publicaciones, comentarios, subida de imágenes y autenticación segura con JWT.
---------------------------------------------------------------------------
🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- JWT (Access Token + Refresh Token)
- Refresh Token en Cookies HttpOnly
- MySQL / H2
- ModelMapper
- Lombok
- Maven
------------------------------------------------
🎯 Objetivo del proyecto

Construir el backend de una red social moderna, similar a Instagram o Facebook, con:
- Autenticación segura
- Gestión de publicaciones
- Comentarios por publicación
- Subida de imágenes
- Roles de usuario
- Seguridad a nivel producción
--------------------------------------------
🧱 Arquitectura
- controller
- service
- repository
- dto
- entity
- exception
- security
------------------------------------------
👥 Roles y permisos
🟢 USER
- Ver publicaciones
- Ver comentarios
- Autenticarse en la plataforma

🔴 ADMIN
- Crear publicaciones
- Editar publicaciones
- Eliminar publicaciones
- Gestionar comentarios
- Moderar contenido
-----------------------------------
🔐 Seguridad
Autenticación
- JWT (Access Token) para proteger endpoints
- Refresh Token persistido en base de datos
- Refresh Token enviado mediante Cookie HttpOnly
- Autenticación stateless

¿Por qué Cookies HttpOnly?
- Protege contra ataques XSS
- El token no es accesible desde JavaScript
- Nivel de seguridad usado en aplicaciones reales

🔄 Flujo de autenticación

1️⃣ Login
- Devuelve Access Token
- Setea Refresh Token en Cookie HttpOnly

2️⃣ Expira el Access Token
- Se llama a /api/auth/refresh
- Se genera un nuevo Access Token automáticamente

3️⃣ Logout
- Se elimina el refresh token
- Se invalida la cookie
------------------------------------
🧠 Buenas prácticas aplicadas

- DTOs para exponer datos
- Entidades desacopladas de la API
- Seguridad basada en roles
- Refresh token seguro
- Cookies HttpOnly
- Código limpio y escalable
- Preparado para frontend web o mobile
------------------------------------
📈 Estado del proyecto

✅ Funcional
✅ Seguro
✅ Escalable
✅ Listo para producción
✅ Ideal para portfolio backend
--------------------------------------
🗺️ Roadmap (futuras mejoras)

- Likes en publicaciones
- Sistema de seguidores (follow / unfollow)
- Feed personalizado
- Historias (stories)
- Chat en tiempo real
- Notificaciones
- Frontend en React / Flutter
- Deploy en la nube
