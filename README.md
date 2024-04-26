# <center> Tutorial Graphql Api
#### <center> [![LinkedIn](https://img.shields.io/badge/-annarafaeladev-0077B5?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/annarafaeladev/)](https://www.linkedin.com/in/annarafaeladev/)

## Start
* git clone https://github.com/annarafaeladev/tutorial-graphql-api.git

### Referencias 
* [Spring Initializer](https://start.spring.io/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#web)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#web.graphql)

### Config

* adicionar a seguinte configuração no ``application.properties`` para habilitar graphql: ``spring.graphql.graphiql.enabled=true``


### Testar
* Rodar o projeto, abrir  uma aba no navegador e ```http://localhost:8080/graphiql``` desse modo abri o console do graphql para executar as querys

### Estrutura
A lógica consiste em criar posts em um forum, e relacionar comentário a ele. A persistencia de dados foi realizada em mémoria apenas para nivel educacional.

Existe 3 endpoints
* Criação de post
  
![img.png](assets/img.png)
  
* Buscar post pelo id

![img_1.png](assets/img_1.png)

* Criar comentário

![img_2.png](assets/img_2.png)

* Carregar os comentario de cada post
  * foi criado um data loader para que isso seja realizado automatico no controller com o mesmo nome definido no schema ```comments```
  * ```
    @SchemaMapping
    public Collection<Comment> comments (Post post) {
        return commentService.findByPost(post.id());
    }
  
![img_3.png](assets/img_3.png)


