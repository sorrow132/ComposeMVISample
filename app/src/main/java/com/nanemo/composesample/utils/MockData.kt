package com.nanemo.composesample.utils

import com.nanemo.composesample.presentation.heroes.HeroState

object MockData {

    val heroItem: HeroState = HeroState(
        10,
        "Doctor Strange",
        "https://static.posters.cz/image/750/%D0%9F%D0%BB%D0%B0%D0%BA%D0%B0%D1%82%D0%B8/doctor-strange-hand-i32870.jpg",
        "",
        "Marvel's \"Doctor Strange\" follows the story of the talented neurosurgeon Doctor Stephen Strange who, after a tragic car accident, must put ego aside and learn the secrets of a hidden world of mysticism and alternate dimensions.",
        isSelected = false,
        isExpanded = false
    )

    val heroesList: List<HeroState> = listOf(
        HeroState(
            1,
            "Spider-man",
            "https://www.parisbeacon.com/wp-content/uploads/2022/03/Spider-Man-No-Way-Home-traje-final.jpg",
            "",
            description = "Superhuman strength, agility, endurance, ability to stick to and climb walls and other surfaces, uses self-designed web-shooters allowing him to fire and swing from sticky webs, special \"Spider-Sense\" warns of incoming danger, genius intellect specializing in chemistry and invention.",
            isSaved = false,
            isSelected = false,
            isExpanded = false
        ),
        HeroState(
            2,
            "Batman",
            "https://static.posters.cz/image/1300/%D0%9F%D0%BB%D0%B0%D0%BA%D0%B0%D1%82%D0%B8/batman-arkham-origins-i97852.jpg",
            "",
            description = "Batman was originally introduced as a ruthless vigilante who frequently killed or maimed criminals, but evolved into a character with a stringent moral code and strong sense of justice. Unlike most superheroes, Batman does not possess any superpowers, instead relying on his intellect, fighting skills, and wealth.",
            isSaved = false,
            isSelected = false,
            isExpanded = false
        ),
        HeroState(
            3,
            "Superman",
            "https://www.rollingstone.com/wp-content/uploads/2018/06/rs-27709-20130611-superman-x624-1370963561.jpg?w=624",
            "",
            description = "Superhuman strength, super speed, stamina and invulnerability, freezing breath, super hearing, multiple extrasensory and vision powers, longevity, flight, and regeneration. Superman is a fictional character and one of the most famous and popular comic book superheroes of all time.",
            isSaved = false,
            isSelected = false,
            isExpanded = true
        ),
        HeroState(
            4,
            "Venom",
            "https://www.cnet.com/a/img/resize/3efa2ce2e06f44972370878211965533c498c79f/2021/09/03/afa4abf1-ea46-45bf-b4d0-84259920a236/qlwgiefucodivdzjgil7.jpg?auto=webp&fit=crop&height=675&width=1200",
            "",
            description = "venom, the poisonous secretion of an animal, produced by specialized glands that are often associated with spines, teeth, stings, or other piercing devices. The venom apparatus may be primarily for killing or paralyzing prey or may be a purely defensive adaptation. Some venoms also function as digestive fluids.",
            isSaved = false,
            isSelected = false,
            isExpanded = false
        ),
        HeroState(
            5,
            "Wonder woman",
            "https://static.wikia.nocookie.net/dccu/images/6/6f/JL_Wonder_Woman.jpg/revision/latest?cb=20160914003449",
            "",
            description = "Wonder Woman is an Amazon, a race of female warriors in Greek mythology. For the purpose of the Wonder Woman character, it was the Greek gods who gave her her powers. These powers include superhuman strength and speed as well as the ability to fly.",
            isSaved = false,
            isSelected = false,
            isExpanded = false
        ),
        HeroState(
            6,
            "Thor",
            "https://images.hindustantimes.com/rf/image_size_960x540/HT/p2/2018/08/31/Pictures/_477cc93a-acfb-11e8-abd2-5c322fa89f61.jpg",
            "",
            description = "Thor is a very tall and well-built Asgardian male; he has very large biceps and long, muscular legs. Fair-skinned and blue-eyed, he has golden blond hair that grows slightly during the events of the Marvel Cinematic Universe, reaching just around his shoulders by Thor: The Dark World.",
            isSaved = false,
            isSelected = false,
            isExpanded = false
        ),
        HeroState(
            7,
            "Loki",
            "https://www.cnet.com/a/img/resize/8ea4a2754702c5b3d7888091cb23d257d406ffef/2021/04/23/6efae7ef-4936-4348-a7b1-6ac158660ac6/7c6df1c8-0ec9-4d36-ac86-6211196d218a-loki-tom-hiddleston.png?auto=webp&fit=crop&height=675&width=1200",
            "",
            description = "Loki Laufeyson is the Trickster God, God of Mischief, Evil, and Lies a member of the monstrous Frost Giants of Jotunheim but was adopted and raised among the Asgardians a group of humanoid beings from the pocket dimension of Asgard, the Realm Eternal.",
            isSaved = false,
            isSelected = false,
            isExpanded = false
        ),
        HeroState(
            8,
            "Iron man",
            "https://static.wikia.nocookie.net/marveldatabase/images/f/fe/Avengers_Endgame_poster_041_Variant_Textless.jpg/revision/latest/top-crop/width/360/height/360?cb=20190629185509",
            "",
            description = "He is the Armored Avenger - driven by a heart that is part machine, but all hero! He is the INVINCIBLE IRON MAN! Iron Man's Powers and Abilities: Wears modular arc reactor-powered Iron Man armor, granting superhuman strength & durability, the ability to fly & project Repulsor blasts.",
            isSaved = false,
            isSelected = false,
            isExpanded = false
        ),
        HeroState(
            9,
            "Captain America",
            "https://i.insider.com/61c1fe9e6bfa2f0019b88406?width=700",
            "",
            description = "He is honest, up-front, loyal, extremely noble, and unfailingly dependable. His strengths don't lie in creativity or brilliance, especially when compared to some other Avengers, but he is the one who can step in and lead all the complex personalities, skill sets, strengths, and weaknesses of this diverse team.",
            isSaved = false,
            isSelected = false,
            isExpanded = false
        )
    )
}