Sample story

Narrative:
As (a renter), I want to be able to search for listings based on criterias, so that I can find exactly the property that fits me

Scenario: Renter searches for listing
Given the browser is open
And the page http://localhost:3000 is displayed
Then the system shows results for more cities than just Odense
When Morten searches for Odense with certain criteria
Then The system shows a full list of all available listings in Odense that matches criteria
And He chooses a listing
Then The contact information of the owner of that listing is presented

Scenario: Renter adds criteria to search
Given the browser is open
And the page http://localhost:3000 is displayed
Given The unfiltered list is presented to Morten
When He types price range into price range field
And He clicks on amount of rooms he wishes
And He clicks on pets allowed
And He clicks on ‘own bathroom’
Then The listings get narrowed down based on the criteria
And Listings in Odense that matches above criteria are presented to Morten

Narrative:
As (a renter) I want to be able to give a review of my landlord, to make sure that other people know that she was a good landlord

Scenario: Renter gives review of landlord
Given: The landlords profile page is presented to Sophie
When: Sophie clicks on the “add review”-button
And: Sophie clicks on 5 stars
And: Sophie writes a small review in the ‘reason’-field
And: Sophie presses the ‘submit’-button
Then: The review is posted to her landlords profile-page
And: Sophies’ review of the landlord is presented so other people can see it