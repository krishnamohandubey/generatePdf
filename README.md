# Generate PDF Microservice

This is a Spring Boot microservice that generates PDFs based on user data passed through an HTTP request. The microservice uses Thymeleaf for templating and OpenHTMLtoPDF for generating PDFs from HTML content.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This microservice takes user data as input, processes it through a Thymeleaf template, and generates a PDF document. The PDF is then returned in the HTTP response.

## Features

- Accepts user data via a POST request
- Processes the data using Thymeleaf templates
- Generates a PDF document using OpenHTMLtoPDF
- Returns the PDF as a response

## Technologies Used

- Java
- Spring Boot
- Thymeleaf
- OpenHTMLtoPDF
- Maven

## Prerequisites

- JDK 11 or higher
- Maven
- Git

## Installation

1. **Clone the repository:**

   ```sh
   git clone https://github.com/krishnamohandubey/generatePdf.git
   cd generatePdf

2. **Call Microservice**

   ```sh
   curl --location 'http://localhost:9090/generate-pdf' \
         --header 'Content-Type: application/json' \
         --data-raw '{
             "name": "Krishna",
             "email": "krishna@example.com",
             "mobile": "99966666666",
             "address": "full address"
         }'
   

   
