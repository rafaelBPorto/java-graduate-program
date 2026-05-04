O controle de versão é feito através do sdkman
https://sdkman.io/install/


Para estudos foi utilizada a distribuição

`Temurin (Eclipse) Formerly AdoptOpenJDK`

Versões instaladas

```shell
sdk install java 25-tem
sdk install java 26-tem
```
Para ver todas as versões baixadas na sua máquina
```shell
sdk list java | grep installed
```

Escolher versão
```shell
sdk use java 25.0.3-tem
```

Para ver a versão ativa
```shell
sdk current java
```

Para alterar a versão padrão de todo o sistema
```shell
sdk default java 25.0.3-tem
```