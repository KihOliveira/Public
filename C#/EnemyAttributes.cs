using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyAttributes: MonoBehaviour
{

    [SerializeField] private int life;
    [SerializeField] private int damage;
    [SerializeField] private float speed;
    [SerializeField] private int armor;
    
    public void SetLife(int life){
        this.life = life;
    }

    public int GetLife(){
        return this.life;
    }

    public void SetDamage(int damage){
        this.damage = damage;
    }

    public int GetDamage(){
        return this.damage;
    }

    public void SetSpeed(float speed){
        this.speed = speed;
    }

    public float GetSpeed(){
        return this.speed;
    }

    public void SetArmor(int armor){
        this.armor = armor;
    }

    public int GetArmor(){
        return this.armor;
    }

    public void TakeDamage(int damage){
        this.life -= (damage - this.armor);
        if(life <= 0 ){
            FindObjectOfType<GameManager>().AddEnemyDeath();
            Destroy(gameObject);
            Debug.Log("Menos um inimigo!");
        }
    }

}
