# Micro-Test API

Micro-Test API is a Spring Boot-based microservice designed to fetch, store, and serve animal images based on specific animal types (e.g., cat, dog, bear). This project provides a RESTful API for fetching images from remote URLs and storing them in a local database.

## Table of Contents
- [Simple Usage](#simple-usage)

## Simple Usage
### Quick Local Install
Clone the repo and run the docker command
```bash
git clone git@github.com:cntlscrut/micro-test.git
cd micro-test
docker compose up --build
```
Service is accessible at http://localhost:8080
Use a tool just as Postman to send requests:
- Requesting a series of random images for a type of "dog" or "bear"
	- POST Request URI: /api/animals/{animalType}/{count}
	- Example:
	  ```bash
	  http://localhost:8080/api/animals/dog/5
	  ```
   	- Result: json repsonse of {count} images that were pulled in. Can be confirmed and queried in H2 db
- Requesting the last image of a series for a type of "dog" or "bear"
	- GET Request URI: /api/animals/{animalType}/last
	- Example:
	```bash
	http://localhost:8080/api/animals/dog/last
	```
 	- Result: a jpeg image should be returned of the last image that was saved of the selected animal type.
	


