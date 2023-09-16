using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class PlayerAttributes : MonoBehaviour {
    
    [SerializeField] private int life;
    [SerializeField] private int damage;    
    [SerializeField] private float speed;
    [SerializeField] private int armor;
    [SerializeField] private int shield;
    [SerializeField] private float invulnerability;
    [SerializeField] private bool style; //0 = ranged 1 = melee

    //[SerializeField] private Special special;

    //private List<Passive> passives = new List<Passive>();

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

    public void SetStyle(bool style){
        this.style = style;
    }

    public bool GetStyle(){
        return this.style;
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
            FindObjectOfType<GameManager>().GameOver();
        }
    }
    
}