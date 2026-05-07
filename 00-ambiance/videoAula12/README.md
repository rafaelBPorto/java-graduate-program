MÓDULO 00 - Aula 11 -PROTECTED

Se eu tiver um pacote dentro de outro pacote
exemplo:
Modelo
  - Cardapio
  isento
    - ItemCardapioIsento

A classe ItemCardapioIsento não consegue mais acessar Cardapio e vice-versa

**Não existe hierarquia de pacotes nos modificadores de acesso do java**

Para resolver uma alternativa é deixar como `public`, mas não é a melhor prática
outra alternativa é utilizar o `protected`
exemplo:
`protected ItemCardapio`

Logo
 # Modificadores de Acesso

private
padrão
protected - acessível no mesmo pacote ou em classes filhas mesmo se estiver em outro pacote
public