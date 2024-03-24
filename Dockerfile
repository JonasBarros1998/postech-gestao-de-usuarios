FROM postgres:15.3-alpine3.18
EXPOSE 5432

#Variaveis de ambiente
ENV POSTGRES_USER=jonas
ENV POSTGRES_PASSWORD=123456
ENV POSTGRES_DB=gestao-de-usuarios