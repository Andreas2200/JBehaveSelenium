Sample story

Narrative:
As (a renter), I want to be able to search for listings based on criterias, so that I can find exactly the property that fits me

Scenario: Renter searches for listing
Given the browser is open
And the page http://localhost:3000 is displayed
Then the system shows results for more cities than just Odense
When Morten searches for Odense with certain criteria
Then the system shows a full list of all available listings in Odense that matches criteria
And he chooses a listing
Then the contact information of the owner of that listing is presented

<<<<<<< HEAD
Scenario: Renter adds criteria to search
Given the browser is open
And the page http://localhost:3000/search is displayed
Given the unfiltered list is presented to Morten
When he types 8000 range into price range field
And he clicks on amount of rooms he wishes
And he clicks on pets allowed
And he clicks on own bathroom
Then the listings get narrowed down based on the criteria
And listings in Odense that matches above criteria are presented to Morten

!-- Narrative:
!-- As (a renter) I want to be able to give a review of my landlord, to make sure that other people know that she was a good landlord
!--
!-- Scenario: Renter gives review of landlord
!-- Given: The landlords profile page is presented to Sophie
!-- When: Sophie clicks on the “add review”-button
!-- And: Sophie clicks on 5 stars
!-- And: Sophie writes a small review in the ‘reason’-field
!-- And: Sophie presses the ‘submit’-button
!-- Then: The review is posted to her landlords profile-page
!-- And: Sophies’ review of the landlord is presented so other people can see it
=======
Narrative:
As (a renter) I want to be able to give a review of my landlord, to make sure that other people know that she was a good landlord

Scenario: Renter gives review of landlord
Given the browser is open
And the page http://localhost:3000/realtor is displayed
When Sophie clicks on 5 stars
And Sophie writes a small review in the ‘reason’-field
And Sophie presses the ‘submit’-button
Then The review is posted to her landlords profile-page
>>>>>>> f9990d9 (adds review test)
