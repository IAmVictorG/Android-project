package com.bobby.mychoiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Random

import com.airbnb.lottie.LottieAnimationView
import android.animation.Animator
import android.view.View
import android.widget.*
import com.bobby.mychoiceapp.R


class MainActivity : AppCompatActivity() {
    private lateinit var animationView: LottieAnimationView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var animationContainer: FrameLayout
    private var questionIndex = 0
    private lateinit var spinner: Spinner
    private var difficulty = 0
    private var vie = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)
        var buttonStart : Button = findViewById<Button>(R.id.button_play)
        buttonStart.setOnClickListener{
            startGame()
        }
    }

    private fun startGame()
    {

        setContentView(R.layout.activity_main)

        spinner = findViewById<Spinner>(R.id.spinner)
        val difficultyArray = arrayOf("Easy", "Normal", "Hard")
        val adapter = ArrayAdapter.createFromResource(this, R.array.difficulty_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Ajoutez un écouteur d'événements pour le Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedDifficulty = difficultyArray[position]
                when (selectedDifficulty) {
                    "Easy" -> difficulty = 0
                    "Normal" -> difficulty = 1
                    "Hard" -> difficulty = 2
                }
                val questions = generateQuestions()
                showQuestions(questions)
            }
            override fun onNothingSelected(parent : AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        animationContainer = findViewById(R.id.animation_container)
        animationView = findViewById(R.id.animation_view)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
    }

    private fun generateQuestions(): List<Question> {
        val easyQuestions  = listOf(
            Question("La Terre est une sphère.", true, "facile"),
            Question("La photosynthèse est le processus par lequel les plantes produisent de l'énergie.", true, "facile"),
            Question("Le sang rouge contient de l'oxygène.", true, "facile"),
            Question("Le cerveau humain est le plus complexe de tous les organismes vivants.", true, "facile"),
            Question("Les virus ne sont pas considérés comme des organismes vivants.", true, "facile"),
            Question("Le squelette humain est composé de 206 os.", true, "facile"),
            Question("Le cœur est un muscle qui pompe le sang dans le corps.", true, "facile"),
            Question("La Terre est entourée d'une atmosphère qui protège les organismes vivants des rayons ultraviolets.", true, "facile"),
            Question("Les plantes ont besoin de lumière pour survivre.", true, "facile"),
            Question("Le téléphone portable est un dispositif électronique qui permet de communiquer à distance.", true, "facile"),
            Question("L'eau est une substance indispensable à la vie.", true, "facile"),
            Question("La Terre tourne autour du Soleil.", true, "facile"),
            Question("Les animaux ont besoin d'air pour respirer.", true, "facile"),

            Question("Le zinc est un métal léger", false, "facile"),
            Question("Le dauphin est un poisson", false, "facile"),
            Question("Le coeur d'un kangourou se trouve dans sa tête", false, "facile"),
            Question("Les éléphants ont une mémoire infaillible", false, "facile"),
            Question("La lune est plus proche de la Terre que le Soleil", false, "facile"),
            Question("Le cerveau humain est capable de stocker une quantité infinie d'informations", false, "facile"),
            Question("Les oiseaux ont des dents", false, "facile"),
            Question("Le système solaire est composé de 8 planètes", false, "facile"),
            Question("Les girafes peuvent seulement baisser la tête", false, "facile"),
            Question("Les crocodiles pleurent pour attirer les proies", false, "facile"),
            Question("L'homme est un animal marin", false, "facile"),
            Question("Les chats ont des poils courts", false, "facile"),
            Question("La vitesse de la lumière dans le vide est plus rapide que celle du son", false, "facile"),
            Question("Le plus grand océan de la Terre est l'océan Atlantique", false, "facile"),
        )

        val normalQuestions = listOf(
            Question("Le cerveau humain est le plus complexe de tous les organismes vivants.", true, "Normal"),
            Question("Les virus ne sont pas considérés comme des organismes vivants.", true, "Normal"),
            Question("Le squelette humain est composé de 206 os.", true, "Normal"),

            Question("C'est Faux", false, "Normal"),
        )

        val hardQuestions = listOf(

            Question("La théorie de la relativité d'Albert Einstein est basée sur la relativité restreinte et la relativité générale.", true, "Hard"),
            Question("La densité de la matière noire est d'environ 10^17 kg/m^3.", true, "Hard"),
            Question("La réaction nucléaire de fusion est utilisée pour produire de l'énergie dans les centrales nucléaires.", true, "Hard"),
            Question("La chromatographie est une technique utilisée pour séparer les composants d'un mélange.", true, "Hard"),
            Question("La théorie de la relativité générale prédit l'existence des ondes gravitationnelles.", true, "Hard"),
            Question("La température absolue zéro est égale à -273,15 degrés Celsius.", true, "Hard"),
            Question("La respiration cellulaire est le processus par lequel les cellules produisent de l'énergie.", true, "Hard"),
            Question("La théorie de la relativité générale prédit la courbure de la lumière par les objets massifs.", true, "Hard"),
            Question("La théorie quantique de la gravité est un modèle qui relie la mécanique quantique à la relativité générale.", true, "Hard"),
            Question("La mécanique quantique est la théorie physique qui décrit le comportement des particules subatomiques.", true, "Hard"),
            Question("La Terre est un ovale allongé.", true, "Hard"),
            Question("La vie sur Terre a commencé il y a environ 3,5 milliards d'années.", true, "Hard"),
            Question("La Révolution française a eu lieu entre 1789 et 1799.", true, "Hard"),
            Question("Napoléon Bonaparte a été couronné empereur de France en 1804.", true, "Hard"),
            Question("La Tour Eiffel a été construite pour l'Exposition Universelle de 1889.", true, "Hard"),
            Question("La France a été gouvernée par une monarchie absolue jusqu'à la Révolution française.", true, "Hard"),
            Question("L'Opéra de Paris, également connu sous le nom de Palais Garnier, a été construit en 1875.", true, "Hard"),
            Question("Le château de Versailles a été utilisé comme résidence principale des rois de France à partir de Louis XIV.", true, "Hard"),
            Question("La Déclaration des Droits de l'Homme et du Citoyen a été adoptée lors de la Révolution française en 1789.", true, "Hard"),
            Question("La bataille de Waterloo, qui a eu lieu en 1815, a vu la défaite de Napoléon Bonaparte et la fin de son règne.", true, "Hard"),
            Question("Les Impressionnistes étaient un groupe d'artistes qui se sont réunis pour la première fois en 1874.", true, "Hard"),
            Question("La prise de la Bastille a eu lieu le 14 juillet 1789.", true, "Hard"),
            Question("Le général Charles de Gaulle a été élu président de la République française en 1958.", true, "Hard"),
            Question("La commune de Paris, qui a eu lieu en 1871, a vu l'émergence d'un gouvernement communautaire à Paris.", true, "Hard"),
            Question("Les Égyptiens ont inventé le système décimal.", true, "Hard"),
            Question("Les Mayas ont développé une écriture complexe.", true, "Hard"),
            Question("Les Chinois ont inventé la poudre à canon.", true, "Hard"),
            Question("Les Indiens ont découvert le zéro.", true, "Hard"),
            Question("Les Sumériens ont développé la première forme d'écriture.", true, "Hard"),


            Question("Le Louvre est le plus grand musée d'art au monde.", false, "Hard"),
            Question("Les Grecs ont développé la médecine moderne.", false, "Hard"),
            Question("Les Incas ont construit des pyramides.", false, "Hard"),
            Question("Les Perses ont inventé le système de numération décimal.", false, "Hard"),
            Question("Les Babyloniens ont construit les premières tours de contrôle de l'air.", false, "Hard"),
            Question("Les Romains ont inventé la vapeur comme source d'énergie.", false, "Hard"),
            Question("La guerre de Cent Ans a duré 100 ans", false, "Hard"),
            Question("La matière noire et l'énergie noire n'existent pas.", false, "Hard"),
            Question("Les étoiles se forment à partir de la combustion de gaz.", false, "Hard"),
            Question("La vie sur Terre a commencé il y a moins de 1 milliard d'années.", false, "Hard"),
            Question("La matière noire est visible à l'oeil nu", false, "Hard"),
            Question("La lumière est plus lente dans l'eau que dans l'air", false, "Hard"),
            Question("La Terre est plate", false, "Hard"),
            Question("Les ondes électromagnétiques ne peuvent pas voyager dans le vide", false, "Hard"),
            Question("La théorie de la relativité générale prédit l'existence des trous noirs", false, "Hard"),
            Question("La température absolue zéro est égale à 0 degrés Celsius", false, "Hard"),
            Question("La respiration cellulaire est un processus qui utilise de l'oxygène pour produire de l'énergie", false, "Hard"),
            Question("La théorie de la relativité générale prédit l'effet de levitation", false, "Hard"),
            Question("La théorie quantique de la gravité est un modèle qui relie la mécanique quantique à la théorie de la relativité restreinte", false, "Hard"),
            Question("La Tour Eiffel a été construite pour l'Exposition universelle de 1867.", false, "Hard"),
            Question("Le drapeau français a été adopté en 1789 à la Révolution française.", false, "Hard"),
            Question("La révolution française a débuté en 1789 et s'est terminée en 1799.", false, "Hard"),
            Question("Louis XIV était connu sous le nom de \"Le Roi Soleil\" en raison de son règne éclairé.", false, "Hard"),
            Question("Le Mona Lisa est un tableau de Raphaël", false, "Hard"),
            Question("La Marseillaise a été écrite par Claude Debussy", false, "Hard"),
            Question("Le Louvre a été construit en tant que palace royal.", false, "Hard"),
            Question("Napoléon Bonaparte a été couronné empereur en 1804.", false, "Hard"),
            Question("Le général Charles de Gaulle a été le premier président de la Cinquième République française.", false, "Hard"),
            Question("La devise de la France est \"Liberté, Égalité, Fraternité\" depuis la Révolution française.", false, "Hard"),
            Question("La France est le pays d'origine de la chanson à succès \"Happy Birthday to You\"", false, "Hard"),
            Question("La Normandie est le nom d'une région de France située dans le sud-ouest", false, "Hard"),
            Question("Les frères Lumière ont inventé le cinéma", false, "Hard"),
            Question("La France a été gouvernée par une monarchie absolue pendant toute son histoire", false, "Hard"),
            Question("Les guerres de religion en France ont eu lieu entre catholiques et protestants", false, "Hard"),
            Question("Le général de Gaulle a été élu président de France à l'âge de 40 ans", false, "Hard"),
            // ...
        )

        var questions = easyQuestions
        if (difficulty == 1)
        {
            questions = normalQuestions
        }
        if (difficulty == 2)
        {
            questions = hardQuestions
        }

        val random = Random()
        val trueQuestions = questions.filter { it.isTrue }
        val falseQuestions = questions.filter { !it.isTrue }
        val randomIndex1 = random.nextInt(trueQuestions.size)
        val randomIndex2 = random.nextInt(falseQuestions.size)
        return listOf(trueQuestions[randomIndex1], falseQuestions[randomIndex2])
    }


    private fun showQuestions(questions: List<Question>) {
        val r = Random().nextInt(10)
        val trueQuestion = questions[0]
        val falseQuestion = questions[1]
        if(r > 5){
            button1.text = trueQuestion.text
            button2.text = falseQuestion.text
        }
        else{
            button1.text = falseQuestion.text
            button2.text = trueQuestion.text
        }
        button1.setOnClickListener {
            if (button1.text == trueQuestion.text) {
                playAnimation(R.raw.animation_success)
            } else {
                playAnimation(R.raw.animation_fail)
            }
        }

        button2.setOnClickListener {
            if (button2.text == trueQuestion.text) {
                playAnimation(R.raw.animation_success)
            } else {
                playAnimation(R.raw.animation_fail)
            }
        }
    }
    private fun playAnimation(animationResId: Int) {
        animationView.setAnimation(animationResId)
        animationContainer.visibility = View.VISIBLE
        animationView.playAnimation()
        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animator: Animator) {}

            override fun onAnimationEnd(animator: Animator) {
                val questions = generateQuestions()
                questionIndex = (questionIndex + 1) % questions.size
                showQuestions(questions)
                animationContainer.visibility = View.GONE
            }

            override fun onAnimationCancel(animator: Animator) {}

            override fun onAnimationRepeat(animator: Animator) {}
        })
    }

    class Question(val text: String, val isTrue: Boolean, val difficulty: String)
}
