

/**
 * Root package for the Medical Plants application.
 * 
 * Package Structure:
 * - models: Entity classes representing database tables
 * - repositories: Data access layer interfaces extending JpaRepository
 * - services: Business logic layer with service interfaces and implementations
 * - controllers: REST controllers handling HTTP requests
 * - dto: Data Transfer Objects for request/response
 * - config: Configuration classes
 * - exceptions: Custom exception classes
 * - utils: Utility classes and helper methods
 * 
 * Best Practices:
 * 1. Controllers should only handle HTTP requests and delegate to services
 * 2. Services contain all business logic and transaction management
 * 3. Repositories handle all data access
 * 4. DTOs are used for data transfer between layers
 * 5. Models represent the database entities
 */
package com.EMSI.medicalPlantes.base; 