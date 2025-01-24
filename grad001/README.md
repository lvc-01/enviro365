# PowerShell Commands using curl

This document contains **curl** commands for interacting with the endpoints of this Spring Boot application.

## 1. Waste Category

- curl -X POST http://localhost:8080/api/wastecategories -H "Content-Type: application/json" -d '{"type": "Plastic", "description": "Items made of plastic.", "example": "Plastic bottles"}'
- curl -X GET http://localhost:8080/api/wastecategories
- curl -X GET http://localhost:8080/api/wastecategories/1
- curl -X PUT http://localhost:8080/api/wastecategories/1 -H "Content-Type: application/json" -d '{"type": "Glass", "description": "Items made of glass", "example": "Glass bottles"}'
- curl -X DELETE http://localhost:8080/api/wastecategories/1

## 2. Recycling Tips

- curl -X POST http://localhost:8080/api/recyclingtips -H "Content-Type: application/json" -d '{"type": "Plastic", "instruction": "Rinse plastic containers before recycling", "location": "Recycling bin"}'
- curl -X GET http://localhost:8080/api/recyclingtips
- curl -X GET http://localhost:8080/api/recyclingtips/1
- curl -X PUT http://localhost:8080/api/recyclingtips/1 -H "Content-Type: application/json" -d '{"type": "Plastic", "instruction": "Flatten plastic bottles before recycling", "location": "Recycling bin"}'
- curl -X DELETE http://localhost:8080/api/recyclingtips/1

## 3. Disposal Guidelines
- curl -X POST http://localhost:8080/api/disposalguidelines -H "Content-Type: application/json" -d '{"wasteType": "Plastic", "description": "Instructions for disposing of plastic items", "methodOfDisposal": "Recycling", "disposalLocation": "Recycling bin"}'
- curl -X GET http://localhost:8080/api/disposalguidelines
- curl -X GET http://localhost:8080/api/disposalguidelines/1
- curl -X PUT http://localhost:8080/api/disposalguidelines/1 -H "Content-Type: application/json" -d '{"wasteType": "Plastic", "description": "Instructions for disposing of plastic items", "methodOfDisposal": "Return to Vendor", "disposalLocation": "Vendor drop-off point"}'
- curl -X DELETE http://localhost:8080/api/disposalguidelines/1
