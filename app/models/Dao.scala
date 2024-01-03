package models

import java.time.ZonedDateTime

/** This represents the instance of the database. It stores mock data for the
  * application.
  */
object Dao {
  var users: Seq[User] = Seq(
    User("Paul Atreides", "muaddib"),
    User("Duncan Idaho", "swordmaster"),
    User("Lady Jessica", "bene-gesserit"),
    User("Thufir Hawat", "mentat"),
    User("Baron Harkonnen", "harkonnen"),
    User("Alia Atreides", "st.alia"),
    User("Stilgar", "fremen_leader"),
    User("Gurney Halleck", "troubadour_warrior"),
    User("Dr. Yueh", "suk_doctor"),
    User("Princess Irulan", "corrin_princess"),
    User("Chani", "fremen"),
    User("Liet-Kynes", "planetologist"),
    User("Feyd-Rautha", "harkonnen_heir"),
    User("Piter De Vries", "twisted_mentat"),
    User("Shaddam IV", "padishah_emperor")
  )
  var posts: Seq[Post] = Seq(
    Post(
      id = 1,
      user = "Paul Atreides",
      likes = Seq(
        Like("Duncan Idaho", utils.randomDateTime()),
        Like("Lady Jessica", utils.randomDateTime()),
        Like("Thufir Hawat", utils.randomDateTime()),
        Like("Gurney Halleck", utils.randomDateTime())
      ),
      imagePath = s"${models.Global.PUBLIC_IMAGES_PATH}/arriving-arrakis.png",
      createdAt = utils.randomDateTime(),
      description =
        "First steps on the sands of Dune. The twin suns witness our resolve. We're ready to face what comes next, together. #Arrakis #NewBeginnings",
      comments = Seq(
        Comment("Duncan Idaho", "The spice must flow!"),
        Comment("Lady Jessica", "Be careful, Paul."),
        Comment("Thufir Hawat", "We must be vigilant."),
        Comment("Gurney Halleck", "We stand together."),
        Comment("Alia Atreides", "The future is uncertain."),
        Comment("Stilgar", "We trust in Muad'Dib."),
        Comment("Dr. Yueh", "May the Maker guide us."),
        Comment("Princess Irulan", "The universe is watching."),
        Comment("Chani", "We are the children of Dune.")
      )
    ),
    Post(
      id = 2,
      user = "Baron Harkonnen",
      likes = Seq(Like("Thufir Hawat", utils.randomDateTime())),
      imagePath = s"${models.Global.PUBLIC_IMAGES_PATH}/baron-plot.png",
      createdAt = utils.randomDateTime(),
      description =
        "Plotting the next big move. Power waits for no one. #HarkonnenRise #GiediPrime",
      comments = Seq(
        Comment("Thufir Hawat", "The Harkonnens are not to be trusted.")
      )
    ),
    Post(
      id = 3,
      user = "Stilgar",
      likes = Seq(
        Like("Paul Atreides", utils.randomDateTime()),
        Like("Alia Atreides", utils.randomDateTime())
      ),
      imagePath = s"${models.Global.PUBLIC_IMAGES_PATH}/arrakeen-siege.png",
      createdAt = utils.randomDateTime(),
      description =
        "We stand united - a storm brewing against the horizon. Arrakis will be free. #Fremen #ArrakisRising",
      comments = Seq(
        Comment("Paul Atreides", "We fight for Arrakis."),
        Comment("Alia Atreides", "For the future of our people.")
      )
    ),
    Post(
      id = 4,
      user = "Gurney Halleck",
      likes = Seq(
        Like("Duncan Idaho", utils.randomDateTime()),
        Like("Paul Atreides", utils.randomDateTime())
      ),
      imagePath = s"${models.Global.PUBLIC_IMAGES_PATH}/training.png",
      createdAt = utils.randomDateTime(),
      description =
        "Another day, another training session. The desert's heat forges the strongest warriors. #TrainingDay #ArrakisTough",
      comments = Seq(
        Comment("Duncan Idaho", "We are ready."),
        Comment("Paul Atreides", "Your leadership is invaluable, Gurney.")
      )
    ),
    Post(
      id = 5,
      user = "Dr. Yueh",
      likes = Seq(Like("Baron Harkonnen", utils.randomDateTime())),
      imagePath = s"${models.Global.PUBLIC_IMAGES_PATH}/yueh.png",
      createdAt = utils.randomDateTime(),
      description =
        "A choice that weighs heavily. The path ahead is fraught with shadows. #DifficultDecisions #TheDoctor'sDilemma",
      comments = Seq(
        Comment("Baron Harkonnen", "I trust you")
      )
    ),
    Post(
      id = 6,
      user = "Princess Irulan",
      likes = Seq(Like("Lady Jessica", utils.randomDateTime())),
      imagePath = s"${models.Global.PUBLIC_IMAGES_PATH}/irulan.png",
      createdAt = utils.randomDateTime(),
      description =
        "Documenting the epic saga. Words carry the weight of worlds. #MuadDibChronicles #HistoryUnfolds",
      comments = Seq(
        Comment("Lady Jessica", "History will remember.")
      )
    ),
    Post(
      id = 7,
      user = "Lady Jessica",
      likes = Seq(
        Like("Paul Atreides", utils.randomDateTime()),
        Like("Alia Atreides", utils.randomDateTime())
      ),
      imagePath = s"${models.Global.PUBLIC_IMAGES_PATH}/jessica.png",
      createdAt = utils.randomDateTime(),
      description =
        "Embracing the trials of Arrakis. The Bene Gesserit way lights our path. #StrengthAndWisdom #MotherOfMuadDib",
      comments = Seq(
        Comment(
          "Paul Atreides",
          "Your guidance is the light in the sandstorm."
        ),
        Comment("Alia Atreides", "Mother, your strength shapes us.")
      )
    ),
    Post(
      id = 8,
      user = "Thufir Hawat",
      likes = Seq(
        Like("Paul Atreides", utils.randomDateTime()),
        Like("Lady Jessica", utils.randomDateTime())
      ),
      imagePath = s"${models.Global.PUBLIC_IMAGES_PATH}/thufir.png",
      createdAt = utils.randomDateTime(),
      description =
        "Analyzing and strategizing every angle. Arrakis won't know what hit it. #MentatMind #HouseAtreidesStrategist",
      comments = Seq(
        Comment(
          "Paul Atreides",
          "Your wisdom is the cornerstone of our house."
        ),
        Comment(
          "Lady Jessica",
          "Thufir, your loyalty and insight are invaluable."
        )
      )
    )
  )
}
