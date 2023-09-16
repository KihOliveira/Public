using UnityEngine;
using TMPro;

public class ClockController : MonoBehaviour
{
    
    [SerializeField] private TMP_Text clockText;
    private float elapsedTime;
    void Update() {
        elapsedTime += Time.deltaTime;
        updateClockUI();
    }

    private void updateClockUI() {
        int hours = Mathf.FloorToInt(elapsedTime / 3600f);
        int minutes = Mathf.FloorToInt((elapsedTime - hours * 3600f) / 60f);
        int seconds = Mathf.FloorToInt((elapsedTime - hours * 3600f) - (minutes * 60f));

        string clockString = string.Format("{0:00}:{1:00}:{2:00}", hours, minutes, seconds);
        clockText.text = clockString;
    }
}
