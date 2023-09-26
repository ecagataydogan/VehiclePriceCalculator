# VehiclePriceCalculator
This is an VehiclePriceCalculator app.

I have shared a sample output of the program below.

SAMPLE OUTPUT:

![Screen Shot 2023-09-27 at 00 58 20 AM](https://github.com/ecagataydogan/VehiclePriceCalculator/assets/101594855/cbf8ed08-9a3d-4b9f-8ac4-8c66c382974f)


In this application there are sold vehicles which has vehicle ID, month of sale, city of sale and production 
year. The sold vehicles are automobile, pickup truck, and bicycle. An automobile could be either a sedan, a 
hatchback, or a minivan.

A file that consists of different sold vehicles’ information is given: HW2_SoldVehicles.csv. The columns of 
this file is given in the following for each different sold vehicle.

The vehicle ID’s of sold vehicles start with prefix ‘S’ for sedan, ‘H’ for hatchback and so on.

Vehicles:
Sedan: vehicle ID, month of sale, city of sale, production year, roof type, engine volume, VAT (%)
Hatchback: vehicle ID, month of sale, city of sale, production year, city mode, engine volume, VAT (%)
Minivan: vehicle ID, month of sale, city of sale, production year, number of seats, engine volume, VAT (%)
Pickup Truck: vehicle ID, month of sale, city of sale, production year, cab type, truck bed type, VAT (%)
Bicycle: vehicle ID, month of sale, city of sale, production year, chain type, seat post, VAT (%)

SCT for special consumption tax.


These are SCT calculations for month of sale, city of sale, production year, roof type, city mode, number of seats, cab type, chain type, truck bed type, seat post.

Month of sale January May August October December
SCT value 0.3 0.4 0.5 0.6 0.7

City of sale Izmir Istanbul Ankara
SCT value 0.1 0.3 0.2

Production Year 2001-2008 2012-2017 2018-2022
SCT value 1.0 1.2 1.6

Roof type Regular Moonroof Sunroof
SCT value 0.5 0.6 0.8

City mode yes no
SCT value 0.15 0.1

Number of seats 4 5 6 7
SCT value 0.1 0.4 0.6 0.8

Cab type regular extended crew
SCT value 2.5 2.8 3

Chain type derailleur onechain doublechain
SCT value 1.1 1.2 1.3

Truck bed type regular tanker trailer
SCT value 0.5 0.8 1.0

Seat post carbonfiber steel aluminum titanium
SCT value 0.8 0.7 0.9 0.6

SCT calculations:
SCT of sedan = (engine volume * 0.2 * roof type) / production year 
SCT of hatchback = (engine volume * 0.3 * production year) + (city mode)
SCT of minivan = (0.6 * production year) / (engine volume + number of seats)
SCT of pickup truck = (truck bed type * production year) / cab type
SCT of bicycle = (chain type * seat post * 0.1) + month of sale

Total price calculations: 
Total price paid for automobile = (Base Price) * (1 + SCT * 0.8) + (1 + VAT/100)
Total price paid for pickup truck = (Base Price) * (1 + (SCT * 0.6)) + (1 + VAT/100)
Total price paid for bicycle = (Base Price * 0.9) * (1 + SCT) + (1 + VAT/100)




