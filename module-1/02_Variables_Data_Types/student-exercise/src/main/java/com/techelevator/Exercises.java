package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;
System.out.println(remainingNumberOfBirds);

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;
System.out.println(numberOfExtraBirds);

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
int numberOfRacoons = 3;
int numberOfRacoonsLeave = 2;
int remainingRacoons = numberOfRacoons - numberOfRacoonsLeave;
System.out.println(remainingRacoons);

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
int numberOfFlowers = 5;
int numberOfBees = 3;
int lessBeesThanFlowers = numberOfFlowers - numberOfBees;
System.out.println(lessBeesThanFlowers);

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
int lonelyPigeon = 1;
int anotherPigeon = 1;
int pigeonsEatingBreadcrumbs = lonelyPigeon + anotherPigeon;
System.out.println(pigeonsEatingBreadcrumbs);

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
int owlsOnFence = 3;
int owlsJoined = 2;
int owlsNow = owlsOnFence + owlsJoined;
System.out.println(owlsNow);

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
int beaversWorkingOnHome = 2;
int beaversWentForSwim = 1;
int beaversLeft = beaversWorkingOnHome - beaversWentForSwim;
System.out.println(beaversLeft);
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
int toucansOnTreeLimb = 2;
int toucansJoined = 1;
int toucansInAll = toucansOnTreeLimb + toucansJoined;
System.out.println(toucansInAll);

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
int squirrelsInTree = 4;
int nutsInTree = 2;
int moreSquirrelsThanNuts = squirrelsInTree - nutsInTree;
System.out.println(moreSquirrelsThanNuts);

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
float quarters = 0.25f;
float dimes = 0.10f;
float nickels = 0.05f;
float moneyFound = quarters + dimes + nickels + nickels;
System.out.println(moneyFound);

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
int brierClassMuffinsBaked = 18;
int macadamsClassMuffinsBaked = 20;
int flanneryClassMuffinsBaked = 17;
int hiltTotalFirstGradeClassMuffinsBaked = brierClassMuffinsBaked + macadamsClassMuffinsBaked + flanneryClassMuffinsBaked;
System.out.println(hiltTotalFirstGradeClassMuffinsBaked);

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
int centsSpentOnYoyo = 24;
int centsSpentOnWhistle = 14;
int totalCentsSpent = centsSpentOnYoyo + centsSpentOnWhistle;
System.out.println(totalCentsSpent);

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows. How many marshmallows did she use
        altogether?
        */
int largeMarshmallows = 8;
int miniMarshmallows = 10;
int totalMarshmallowsUsed = largeMarshmallows + miniMarshmallows;
System.out.println(totalMarshmallowsUsed);

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
int hiltHouseInchesOfSnow = 29;
int brecknockElementarySchoolInchesOfSnow = 17;
int inchesMoreOfSnowAtHiltHouseThanSchool = hiltHouseInchesOfSnow - brecknockElementarySchoolInchesOfSnow;
System.out.println(inchesMoreOfSnowAtHiltHouseThanSchool);
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
int beginningAmountOfDollars = 10;
int dollarsSpentOnToyTruck = 3;
int dollarsSpentOnPencilCase = 2;
int dollarsMrsHiltHasLeft = beginningAmountOfDollars - (dollarsSpentOnToyTruck + dollarsSpentOnPencilCase);
System.out.println(dollarsMrsHiltHasLeft);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
int collectionOfMarbles = 16;
int marblesLost = 7;
int marblesJoshHasLeft = collectionOfMarbles - marblesLost;
System.out.println(marblesJoshHasLeft);

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
int seashellsMeganWants = 25;
int seashellsMeganHas = 19;
int seashellsMeganNeeds = seashellsMeganWants - seashellsMeganHas;
System.out.println(seashellsMeganNeeds);

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
int totalRedAndGreenBalloonsOfBrad = 17;
int redBalloonsOfBrad = 8;
int greenBalloonsOfBrad = totalRedAndGreenBalloonsOfBrad - redBalloonsOfBrad;
System.out.println(greenBalloonsOfBrad);

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
int booksOnShelf = 38;
int booksMartaAddedToShelf = 10;
int booksOnShelfNow = booksOnShelf + booksMartaAddedToShelf;
System.out.println(booksOnShelfNow);

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
int legsBeesHave = 6;
int amountOfBees = 8;
int legsOfEightBees = legsBeesHave * amountOfBees;
System.out.println(legsOfEightBees);
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
double twoIceCreamConesCost = 0.99 * 2;
System.out.println(twoIceCreamConesCost);

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
int totalRocksNeededForBorder = 125;
int rocksMrsHiltHas = 64;
int rocksMrsHiltNeedsToCompleteBorder = totalRocksNeededForBorder - rocksMrsHiltHas;
System.out.println(rocksMrsHiltNeedsToCompleteBorder);

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
int marblesMrsHiltHad = 38;
int marblesMrsHiltLost = 15;
int marblesMrsHiltHasLeft = marblesMrsHiltHad - marblesMrsHiltLost;
System.out.println(marblesMrsHiltHasLeft);

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
int milesToConcert = 78;
int milesDrivenSoFar = 32;
int milesLeftToDrive = milesToConcert - milesDrivenSoFar;
System.out.println(milesLeftToDrive);

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
int minutesSpentShovelingSnowSat = 90;
int minutesSpentShovelingSnowSun = 45;
int minutesSpentShovelingSnowTotal = minutesSpentShovelingSnowSat + minutesSpentShovelingSnowSun;
double hoursSpentShovelingSnowTotal = minutesSpentShovelingSnowTotal / 60.0;
System.out.println(minutesSpentShovelingSnowTotal);
System.out.println(hoursSpentShovelingSnowTotal);

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
int hotDogsPurchased = 6;
double centsPerHotDog = 0.50;
double dollarsSpentOnHotDogs = hotDogsPurchased * centsPerHotDog;
System.out.println(dollarsSpentOnHotDogs);

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
int centsMrsHiltHas = 50;
int centsForAPencilCase = 7;
int pencilCasesMrsHiltCanBuy = centsMrsHiltHas / centsForAPencilCase;
System.out.println(pencilCasesMrsHiltCanBuy);

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
int totalRedAndOrangeButterflies = 33;
int totalOrangeButterflies = 20;
int totalRedButterflies = totalRedAndOrangeButterflies - totalOrangeButterflies;
System.out.println(totalRedButterflies);

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
int totalKatePaid = 1;
float costOfCandy = 0.54f;
float changeKateIsOwed = totalKatePaid - costOfCandy;
System.out.println(changeKateIsOwed);

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
int treesInMarksBackyardBeforePlanting = 13;
int treesMarkPlants = 12;
int treesInMarksBackyardNow = treesInMarksBackyardBeforePlanting + treesMarkPlants;
System.out.println(treesInMarksBackyardNow);

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
int daysUntilJoySeesGrandma = 2;
int hoursInOneDay = 24;
int hoursUntilJoySeesGrandma = daysUntilJoySeesGrandma * hoursInOneDay;
System.out.println(hoursUntilJoySeesGrandma);

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
int cousinsKimHas = 4;
int piecesOfGumPerCousin = 5;
int totalPiecesOfGumNeeded = cousinsKimHas * piecesOfGumPerCousin;
System.out.println(totalPiecesOfGumNeeded);

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
int dollarsDanHas = 3;
int dollarsDanPaidForACandyBar = 1;
int dollarsDanHasLeft = dollarsDanHas - dollarsDanPaidForACandyBar;
System.out.println(dollarsDanHasLeft);

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
int boatsInTheLake = 5;
int peoplePerBoat = 3;
int peopleOnBoatsInTheLake = boatsInTheLake * peoplePerBoat;
System.out.println(peopleOnBoatsInTheLake);

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
int legosEllenHad = 380;
int legosEllenLost = 57;
int legosEllenHasLeft = legosEllenHad - legosEllenLost;
System.out.println(legosEllenHasLeft);

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
int muffinsArthurBaked = 35;
int muffinsArthurWants = 83;
int muffinsArthurStillNeedsToBake = muffinsArthurWants - muffinsArthurBaked;
System.out.println(muffinsArthurStillNeedsToBake);

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
int crayonsWillyHas = 1400;
int crayonsLucyHas = 290;
int amountMoreOfCrayonsWillyHasThanLucy = crayonsWillyHas - crayonsLucyHas;
System.out.println(amountMoreOfCrayonsWillyHasThanLucy);
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
int stickersPerPage = 10;
int pagesOfStickers = 22;
int totalStickers = stickersPerPage * pagesOfStickers;
System.out.println(totalStickers);

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
int totalCupcakes = 96;
int totalChildren = 8;
int cupcakesPerChild = totalCupcakes / totalChildren;
System.out.println(cupcakesPerChild);

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
int totalGingerbreadCookies = 47;
int cookiesPerJar = 6;
int cookiesNotInAJar = totalGingerbreadCookies % cookiesPerJar;
System.out.println(cookiesNotInAJar);

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
int croissantsPrepared = 59;
int neighborsToReceiveCroissants = 8;
int croissantsLeftWithMarian = croissantsPrepared % neighborsToReceiveCroissants;
System.out.println(croissantsLeftWithMarian);

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
int cookiesPerTray = 12;
int amountOfCookiesMarianWants = 276;
int traysNeeded = amountOfCookiesMarianWants / cookiesPerTray;
System.out.println(traysNeeded);

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
int pretzelsMade = 480;
int servingOfPretzels = 12;
int totalServingsPrepared = pretzelsMade / servingOfPretzels;
System.out.println(totalServingsPrepared);

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
int totalLemonCupcakesBaked = 53;
int lemonCupcakesLeftAtHome = 2;
int lemonCupcakesPerBoxToBeGivenAway = 3;
int boxesOfCupcakesGivenAwayAtOrphanage = (totalLemonCupcakesBaked - lemonCupcakesLeftAtHome) / lemonCupcakesPerBoxToBeGivenAway;
System.out.println(boxesOfCupcakesGivenAwayAtOrphanage);

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
int carrotSticksPrepared = 74;
int amountOfPeopleServedCarrotSticksEqually = 12;
int carrotSticksLeftUneaten = carrotSticksPrepared % amountOfPeopleServedCarrotSticksEqually;
System.out.println(carrotSticksLeftUneaten);

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
int totalTeddyBears = 98;
int teddyBearsPerShelf = 7;
int amountOfShelvesFilledWithTeddyBears = totalTeddyBears / teddyBearsPerShelf;
System.out.println(amountOfShelvesFilledWithTeddyBears);

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
int totalFamilyPictures = 480;
int amountOfFamilyPicturesInAnAlbum = 20;
int amountOfAlbumsNeeded = totalFamilyPictures / amountOfFamilyPicturesInAnAlbum;
System.out.println(amountOfAlbumsNeeded);

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
int totalTradingCardsInJoesRoom = 94;
int amountOfTradingCardsAFullBoxCanHold = 8;
int totalFullBoxes = totalTradingCardsInJoesRoom / amountOfTradingCardsAFullBoxCanHold;
int amountOfCardsInTheUnfilledBox = totalTradingCardsInJoesRoom % amountOfTradingCardsAFullBoxCanHold;
System.out.println(totalFullBoxes);
System.out.println(amountOfCardsInTheUnfilledBox);

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
int booksToBeDistributedEquallyOnShelves = 210;
int amountOfShelvesRepaired = 10;
int amountOfBooksOnEachRepairedShelf = booksToBeDistributedEquallyOnShelves / amountOfShelvesRepaired;
System.out.println(amountOfBooksOnEachRepairedShelf);

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
int totalCroissantsBaked = 17;
int totalGuestsToReceiveEqualAmountOfCroissants = 7;
int amountOfCroissantsPerGuest = totalCroissantsBaked / totalGuestsToReceiveEqualAmountOfCroissants;
int croissantsLeftUneaten = totalCroissantsBaked % totalGuestsToReceiveEqualAmountOfCroissants;
System.out.println(amountOfCroissantsPerGuest);
System.out.println(croissantsLeftUneaten);

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painters working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
int roomSizeInFeet = 52;
int amountOfRoomsToBePainted = 5;
float hourlyRateOfBill = 2.15f;
float hourlyRateOfJill = 1.90f;
float totalHourlyRate = hourlyRateOfBill + hourlyRateOfJill;
int totalFeetNeedingPainted = roomSizeInFeet * amountOfRoomsToBePainted;
double amountOfTimeToPaintAllRooms = totalFeetNeedingPainted / totalHourlyRate;
System.out.println(totalHourlyRate);
System.out.println(totalFeetNeedingPainted);
System.out.println(amountOfTimeToPaintAllRooms);
int secondAmountOfRoomsToBePainted = 623;
int hoursWorkedPerDay = 8;
int secondAmountOfFeetToBePainted = secondAmountOfRoomsToBePainted * roomSizeInFeet;
int fullDaysToPaintSecondAmountOfRooms = secondAmountOfFeetToBePainted / hoursWorkedPerDay;
int hoursLeftOutsideFullDaysOfPainting = secondAmountOfFeetToBePainted % hoursWorkedPerDay;
System.out.println(secondAmountOfFeetToBePainted);
System.out.println(fullDaysToPaintSecondAmountOfRooms);
System.out.println(hoursLeftOutsideFullDaysOfPainting);

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

String firstName = " Laura ";
String lastName = "Ebel,";
String middleInitial = "E.";
String fullName = lastName + firstName + middleInitial;
System.out.println(fullName);


        /*
        The distance between New York and Chicago is 800 miles, and the train has already traveled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already traveled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */


	}

}
