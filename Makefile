SHELL := /bin/bash
DOCKER ?= docker
GRADLEW ?= ./gradlew
IMAGE_NAME := 'phoenix-api'
CONTAINER_NAME := 'phoenix-service-api'
USERNAME := 'bsgfb'

GRADLEW_CLEAN_BUILD := ${GRADLEW} clean build
DOCKER_BUILD := ${DOCKER} build -t ${IMAGE_NAME} .
DOCKER_RUN := ${DOCKER} run -it --rm --name ${CONTAINER_NAME} -p 8081:8081 -d ${IMAGE_NAME}

build:
	${GRADLEW_CLEAN_BUILD}
	${DOCKER_BUILD}

run:
	${DOCKER_RUN}

full:
	${GRADLEW_CLEAN_BUILD}
	${DOCKER_BUILD}
	${DOCKER_RUN}

stop:
	${DOCKER} build ${CONTAINER_NAME}

push:
	${GRADLEW_CLEAN_BUILD}
	${DOCKER_BUILD}
	${DOCKER} tag ${IMAGE_NAME} ${USERNAME}/${IMAGE_NAME}
	${DOCKER} push ${USERNAME}/${IMAGE_NAME}
