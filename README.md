# Contract-Generator-Service

We are tasked with writing a service that generates a contract
Inputs:

1. The blob of text with placeholders
2. Map of placeholder text -> placeholder values

Output:
1. Text with placeholders removed and values inserted.
Requirements:
1. Production ready
2. Unit tests
E.g.

Input:
blob = ‘{{Company Name}} is committed to a policy of vigorous, lawful, and ethical competition which is based on the merits of our {{Company products}}.’
mapping = {
    Company Name = Evisort
    Company products = products and services
}

Output:

Evisort is committed to a policy of vigorous, lawful, and ethical competition which is based on the merits of our products and services.
