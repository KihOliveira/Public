using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour {

    [SerializeField] private int enemyDeathCounter = 0;
    private Time timeElapsed;

    public void GameOver(){
        Debug.Log("Game Over!");
        //Save points
        //Return to main menu
    }

    void ReturnToMenu(){
        SceneManager.LoadScene("MainMenu");
    }

    private void FixedUpdate() {
        
    }

    public int GetEnemyDeathCounter(){
        return this.enemyDeathCounter;
    }

    public void AddEnemyDeath(){
        this.enemyDeathCounter++;
        Debug.Log("Inimigos mortos: "+ GetEnemyDeathCounter());
    }
}
