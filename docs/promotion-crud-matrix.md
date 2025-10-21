# Promotion CRUD Matrix

This matrix outlines the CRUD (Create, Read, Update, Delete) operations required for the promotions feature based on the frontend interactions in `FrontEnd/promotion.html`. It maps frontend actions to backend endpoints, indicating existing implementations and proposed additions for the backend developer.

| Operation | Frontend Action | Backend Endpoint | HTTP Method | Description | Status |
|-----------|-----------------|------------------|-------------|-------------|--------|
| **Create** | Click "New Promotion" button in header or select an option in "Create New Promotion" section (AI-Generated, Standard Sale, Bundle Deal). | `/promotions` | POST | Create a new promotion with details like start/end date, items, promo code, discount, and type. Body should include promotion data (e.g., via PromoResource DTO). | Existing (addPromotion endpoint) |
| **Read (All)** | Load the promotions page to display the grid of AI-generated promotions. | `/promotions/findAllPromotions` | GET | Retrieve a list of all promotions, including details like name, status, discount, products, and projected revenue for display in cards. | Existing |
| **Read (By ID)** | Click on a promotion card to view/edit details (assumed based on clickable cards). | `/promotions/findPromotionByID?PromoID={id}` | GET | Retrieve a single promotion by its ID for detailed view or editing. | Existing |
| **Update** | Click the "Customize" button on a promotion card or edit via card click. | `/promotions/{id}` | PUT | Update an existing promotion's details (e.g., discount, items, dates). Body should include updated promotion data. | Proposed (add new endpoint) |
| **Delete** | (Not explicitly shown in frontend, but recommended for completeness) - Add a delete button/icon to promotion cards if needed. | `/promotions/{id}` | DELETE | Delete a promotion by its ID. | Proposed (add new endpoint) |

## Notes
- **Existing Endpoints**: Based on current PromoController implementation. Create and Read operations are already supported.
- **Proposed Endpoints**: Update and Delete are not implemented yet. The backend should add PUT and DELETE methods to PromoController, using PromoCommandService for updates and PromoRepository for persistence.
- **Data Models**: Use the Promotion aggregate (from domain/model/aggregates/Promotion.java) and related DTOs (e.g., PromoResource). Ensure consistency with shared domain models in sharedDomain/.
- **Additional Considerations**:
  - For Create: Support different promotion types (e.g., AI-generated, standard, bundle) via a type field in the request body.
  - For Read: Include filtering/sorting options (e.g., by potential impact, start date) as shown in the frontend dropdown.
  - For Update: Allow partial updates (e.g., only change discount or items).
  - Error handling: Return appropriate HTTP status codes (e.g., 404 for not found, 400 for invalid data).
  - Security: Ensure endpoints are secured (e.g., via authentication) if not already.
- **Frontend Integration**: The frontend assumes these endpoints exist. Update the JS in promotion.html (e.g., for card clicks and customize buttons) to call the appropriate endpoints via AJAX/fetch.

If any endpoints need adjustments or additional fields, provide more details from the backend implementation.
