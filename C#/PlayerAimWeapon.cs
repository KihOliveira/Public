using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerAimWeapon : MonoBehaviour
{
    private Transform aimTransform;
    [SerializeField] private Transform firepoint;
    [SerializeField] private GameObject bulletPrefab; //Objeto projétil ou ataque corpo a corpo
    [SerializeField] private bool canFire;
    [SerializeField] private float timer;
    [SerializeField] private float timeBetweeenFire; //Cooldown do tiro
    
    private static Vector3 GetMouseWorldPosition2D(Vector3 screenPosition, Camera cam){
        Vector3 mouseWorldPosition = cam.ScreenToWorldPoint(screenPosition);
        mouseWorldPosition.z = 0f;
        return mouseWorldPosition;
    }

    private void Awake(){
        aimTransform = transform.Find("Aim");//Procura o game object Aim e considera como o aimTransform
    }

    private void Update(){
        Aim();
        HandleShoot();
    }

    private void Aim(){
        Vector3 mousePosition = GetMouseWorldPosition2D(Input.mousePosition, Camera.main);
        Vector3 aimDirection = (mousePosition - transform.position).normalized;
        float angle = Mathf.Atan2(aimDirection.y, aimDirection.x) * Mathf.Rad2Deg; //Cria um angulo, resultante da funcao Atan2 convertido de rad para graus
        aimTransform.eulerAngles = new Vector3(0, 0, angle); //Altera a posicao da mira usando um vetor, onde o z é o angulo de euler

    }

    private void HandleShoot(){
        if (!canFire){
            timer += Time.deltaTime; //Conta o tempo que passou desde o ultimo tiro
            if (timer > timeBetweeenFire){
                canFire = true;
                timer = 0;
            }
        }
        if (Input.GetMouseButtonDown(0) && canFire){
            Shoot();
        }
    }

   private void Shoot(){
        Instantiate(bulletPrefab, firepoint.position, Quaternion.identity);//Quaternion.identity faz com que a prefab se alinhe perfeitamente com o transform
    }

    public void SetTimeBetweeenFire(float timeBetweeenFire){
        this.timeBetweeenFire = timeBetweeenFire;
    }

    public void SetBulletPrefab(GameObject bulletPrefab){
        this.bulletPrefab = bulletPrefab;
    }
}
