STACK_NAME=awsdevday2023tokyo-sls-pure-java

build:
	mvn clean package

sam-deploy-g:
	sam deploy --guided --stack-name ${STACK_NAME}

sam-deploy:
	sam deploy

sam-delete:
	sam delete