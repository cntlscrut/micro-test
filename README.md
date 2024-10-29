# Micro-Test API

Micro-Test API is a Spring Boot-based microservice designed to fetch, store, and serve animal images based on specific animal types (e.g., cat, dog, bear). This project provides a RESTful API for fetching images from remote URLs and storing them in a local database.

## Table of Contents
- [Installation](#installation)
  - [Docker](#docker)
  - [Maven](#maven)
- [API Documentation](#api-documentation)
  - [Fetch and Store Animal Images](#fetch-and-store-animal-images)
  - [Retrieve the Last Stored Image for an Animal Type](#retrieve-the-last-stored-image-for-an-animal-type)

## Installation

### Docker

To build and run the project using Docker:

1. Ensure Docker is installed and running on your machine.
2. Clone the repository:
   ```bash
   git clone https://github.com/cntlscrut/micro-test.git
   cd micro-test
   docker build -t micro-test-api .
   docker run -p 8080:8080 micro-test-api
   ```
3. Or
	```bash
	docker compose up --build
	```
The API will be accessible at http://localhost:8080

### Maven

To build and run the project with Maven:

1. Ensure you have Maven installed.
2. Clone the repository:
	```bash
	git clone https://github.com/cntlscrut/micro-test.git
	cd micro-test
	mvn clean install
	mvn spring-boot:run
	mvn spring-boot:run
	```
The API will be accessible at http://localhost:8080

### API Documentation

The following endpoints are available for interacting with the API.
### Fetch and Store Animal Images

Fetch images from a remote URL and store them in the database.

 -     Endpoint: POST /api/v1/animal-images/fetch
 -    Description: Fetches and saves animal images based on the specified animal type and count.
 -    Parameters:
 -        animalType (query parameter, required): The type of animal image to fetch (e.g., cat, dog, bear).
 -        count (query parameter, required): The number of images to fetch and save.
 -    Example:

    ```bash

    curl -X POST "http://localhost:8080/api/v1/animal-images/fetch?animalType=cat&count=5"
    ```

 -    Response:
        Returns a list of saved images with their IDs and metadata.

### Retrieve the Last Stored Image for an Animal Type

 - Retrieve the last image stored for a specific animal type.

    Endpoint: GET /api/v1/animal-images/{animalType}/last
    Description: Fetches the last stored image for the specified animal type.
    Path Parameter:
        animalType (path parameter, required): The type of animal image to retrieve (e.g., cat, dog, bear).
    Example:

    ```bash
	curl -X GET "http://localhost:8080/api/v1/animal-images/cat/last"
	```

 - Response:

     - Returns the image data as a JPEG image if found, or a 404 Not Found status if no image exists for the specified animal type.

