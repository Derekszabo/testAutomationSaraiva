# Automação de testes do website saraiva.com

***Instruções:***

* Executável pela IDE Eclipse.
* Instalar complementos do TestNG no Eclipse
* Instalar a biblioteca lombok.jar também no Eclipse
* Verificar a classe "massas.yaml" para ver qual ID de massa irá usar.
* Abrir o "-data.properties" respectivo a funcionalidade que quiser testar, e nele colocar o(s) ID(s) da(s) massa(s) que quer usar
* Abrir a classe "runner" da funcionalidade que quiser testar, e acessar a opção "Run as > TestNG Test"

***Comentários acerca das Stories apresentadas:***

Story 001:

Não sei se o case era antigo, ou se era proposital, mas alguns dos dados passados no case não condiziam com o site, como por exemplo, não haviam asteriscos nos campos obrigatórios e não havia um radio button para receber ofertas ou não, e sim, campos em vermelho e um checkbox, respectivamente. Por via das dúvidas, falhei o teste seguindo a solicitação original, e fiz cenários nos quais achei conveniente, corrigindo as solicitações que entendi serem desatualizadas.

Houve um bug na grafia do alerta de campo obrigatório de CPF, estando escrito 'Inform um CPF válido' no lugar de 'Informe um CPF válido'

Story 002:

Acredito que a loja está desencorajando a compra de livros digitais, vide que não consta a opção no menu, para acessar, tive que ir direto pelo link, e nenhum livro consta em estoque.

E ao contrário do que diz na Story, é permitido sim adicionar um livro físico e um digital no mesmo carrinho. Há um teste falhando essa validação. 