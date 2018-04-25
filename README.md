sudo docker build . -t dev-mysql
sudo docker run -p 3306:3306 --name=shop -it --rm dev-mysql