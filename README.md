# Pharmacy Management System

Welcome to the **Pharmacy Management System**! This application is designed to streamline pharmacy operations, allowing efficient management of customers, employees, and various pharmacy operations.

## Table of Contents

- [Entities](#entities)
- [Frames](#frames)
- [Interfaces](#interfaces)
- [Repositories](#repositories)
- [Installation](#installation)


## Entities

The system uses the following entities:

- **Customer**: Represents pharmacy customers.
- **Employee**: Represents pharmacy staff members.
- **Owner**: Represents the pharmacy owner with administrative privileges.
- **User**: Represents a generic user entity for authentication.

## Frames

The graphical user interface consists of the following frames:

- **CustomerHomeFrame**: The main interface for customers to interact with the system.
- **EmployeeHomeFrame**: The main interface for employees to manage operations.
- **LoginFrame**: The login screen for all users.
- **OwnerHomeFrame**: The dashboard for the owner to oversee operations.
- **OwnerOperationFrame**: For performing owner-specific operations.
- **PurchaseMedicineFrame**: For managing medicine purchases.
- **SignupFrame**: The interface for new users to create accounts.

## Interfaces

The following interfaces are implemented for data access and manipulation:

- **CustomerRepo**: Interface for managing customer data.
- **EmployeeRepo**: Interface for managing employee data.
- **OwnerRepo**: Interface for managing owner data.
- **UserRepo**: Interface for managing user authentication.

## Repositories

The system utilizes the following repositories:

- **data**: Contains all data-related operations.
- **CustomerRepo**: Implements customer data operations.
- **EmployeeRepo**: Implements employee data operations.
- **FileIO**: Handles file input/output operations for data persistence.
- **OwnerRepo**: Implements owner data operations.
- **UserRepo**: Implements user authentication operations.

## Installation

To set up the project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/pharmacy-management.git
   cd pharmacy-management
2. Ensure you have Java and any necessary dependencies installed.

