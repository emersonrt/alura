FROM node:14.13.1 as angular
ENV NODE_ENV=production
WORKDIR /app
COPY package.json /app
RUN npm install --silent
COPY . .

RUN ./node_modules/.bin/ng build --prod

FROM nginx:alpine
VOLUME [ "/var/cache/nginx" ] 
COPY --from=angular app/dist/bytebank /usr/share/nginx/html
COPY ./config/nginx.conf /etc/nginx/conf.d/default.conf

#FROM clue/json-server:latest
#WORKDIR /home/
#COPY --from=angular app/dados/db.json /home/
#RUN json-server --watch db.json

# docker build -t bytebank .
# docker run -p 8081:80 bytebank