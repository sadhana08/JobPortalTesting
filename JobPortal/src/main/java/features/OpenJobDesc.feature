Feature: Search for a job and open the job description of a job posting

Scenario: Positive inputs
When search jobs is clicked
And enter the designation as "Test Engineer", years of experience and location as "Banglore"
And click search
And any of the job opening box is clicked a new window with the job details will open
And screenshot of the job desction will be taken